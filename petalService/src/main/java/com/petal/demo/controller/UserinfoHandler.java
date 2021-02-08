package com.petal.demo.controller;

import com.petal.demo.entity.Userinfo;
import com.petal.demo.repository.UserinfoRepository;
import com.petal.demo.tools.loginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/userLogSign")
public class UserinfoHandler {
    @Autowired
    private UserinfoRepository userinfoRepository;

    @GetMapping("/findAll")
    public List<Userinfo> findAll(){
        return userinfoRepository.findAll();
    }

    @PostMapping("/checkLogin")
    public loginRes checkLogin(@RequestBody Userinfo userinfo){
        loginRes loginRes=new loginRes(false,"not init",userinfo);
        Userinfo _userinfo = userinfoRepository.findById(userinfo.getUif_id()).orElse(null);

        if (_userinfo==null){
            loginRes.setFlag(false);
            loginRes.setMessage("UserID "+userinfo.getUif_id()+" is not exist");
        }else {
            if (_userinfo.getUif_password().equals(userinfo.getUif_password())){
                loginRes.setFlag(true);
                loginRes.setMessage("success");
                String[] _club=new String[2];
                _club[0]=_userinfo.getUif_gender();
                _club[1]=_userinfo.getUif_id();
                loginRes.setObjectImp(_club);
            }else {
                loginRes.setFlag(false);
                loginRes.setMessage("wrong password");
            }
        }

        return loginRes;
    }

    @PostMapping("/signup")
    public loginRes signup(@RequestBody Userinfo userinfo){
        loginRes loginRes=new loginRes(false,"not init",userinfo);

        Userinfo _userinfoExist = userinfoRepository.findById(userinfo.getUif_id()).orElse(null);

        if (_userinfoExist!=null){
            loginRes.setMessage("UserID is multiple");
        }else {
            loginRes.setFlag(true);
            Userinfo _userinfoNew=userinfoRepository.save(userinfo);
            System.out.println(_userinfoNew);
            loginRes.setMessage("Sign up successfully");
            String[] _club=new String[2];
            _club[0]=_userinfoNew.getUif_gender();
            _club[1]=_userinfoNew.getUif_id();
            loginRes.setObjectImp(_club);
        }
        return loginRes;


    }
}
