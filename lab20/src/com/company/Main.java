package com.company;
//Необходимо создать класс, работающий с напряжением 380 вольт и создать класс работающий с зарядным устройством 220 вольт.
// Создать класс адаптер, который позволит заряжать телефон зарядным устройством 220 вольт через напряжение в 380 вольт.
interface Connect380{
    void Power380();
}
interface Connect220{
    void Power220();
}
class Volt380 implements Connect380{
        @Override
        public void Power380(){
            System.out.println("Используется 380 В");
        }
}
class Volt220 implements Connect220{
    @Override
    public void Power220(){
        System.out.println("Используется 220 В");
    }
}
class Socket{
    private Connect380 hConnect;
    public Socket(Connect380 hConnect){
        this.hConnect = hConnect;
    }
    public void work(){
        hConnect.Power380();
    }
}
class SocketAdapter implements Connect380{
    Connect220 lConnect;
    public SocketAdapter(Connect220 lConnect){
        this.lConnect = lConnect;
    }
    public void Power380(){
        lConnect.Power220();
    }
}
public class Main{
    public static void main(String[] args){
        Volt380 hVolt = new Volt380();
        Socket hSocket = new Socket(hVolt);
        hSocket.work();
        Volt220 lVolt = new Volt220();
        SocketAdapter socketAdapter = new SocketAdapter(lVolt);
        Socket lSocket = new Socket(socketAdapter);
        lSocket.work();
    }
}