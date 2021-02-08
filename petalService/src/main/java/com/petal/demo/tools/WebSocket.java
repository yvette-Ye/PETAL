package com.petal.demo.tools;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@ServerEndpoint("/webSocket/{username}")
@Component
public class WebSocket {
    private static int onlineCount = 0;
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) throws IOException {

        this.username = username;
        this.session = session;

        addOnlineCount();
        clients.put(username, this);
        System.out.println(username+" 已加入");
        System.out.println("已连接");
        this.session.getAsyncRemote().sendText("session="+session.toString());
    }

    @OnClose
    public void onClose() throws IOException {
        System.out.println(username+" 已退出");
        clients.remove(username);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message) throws IOException {

        String[] messages =message.split("!&!");

        String mes=messages[0];
        String to=messages[1];
        String flag=messages[2];
        String useridH=messages[3];

        if (!to.equals("All")){
            sendMessageTo(mes, to, flag, useridH);
        }else{
            sendMessageAll("给所有人");
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    //message在这里代表用户id 或者 时间  to表示要发送给谁  flag表示数据作用类型  useridH表示是谁发送的
    public void sendMessageTo(String message, String To, String flag, String useridH) throws IOException {
        // session.getBasicRemote().sendText(message);
        //session.getAsyncRemote().sendText(message);
        System.out.println("'sendMessageTo' send movieid to "+To);
        for (WebSocket item : clients.values()) {
            System.out.println(item.session);
            if (item.username.equals(To) ) {
//                System.out.println("send movieid to " + To);
                if (flag.equals("movieid")){
                    //此处movieId已经更改成movieName
                    item.session.getAsyncRemote().sendText("movieId:"+message+":"+useridH);
                }else if (flag.equals("timePlay")){
                    item.session.getAsyncRemote().sendText("timePlay:"+message+":"+useridH);
                }else if (flag.equals("timePause")){
                    item.session.getAsyncRemote().sendText("timePause:"+message+":"+useridH);
                }else if (flag.equals("attitude")){
                    item.session.getAsyncRemote().sendText("attitude:"+message+":"+useridH);
                }else if (flag.equals("bulletText")){
                    item.session.getAsyncRemote().sendText("bulletText:"+message+":"+useridH);
                }else {
                    item.session.getAsyncRemote().sendText(message);
                }
            }

        }
        System.out.println(clients);
    }

    public void sendMessageAll(String message) throws IOException {
        for (WebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

    public static synchronized Map<String, WebSocket> getClients() {
        return clients;
    }
}
