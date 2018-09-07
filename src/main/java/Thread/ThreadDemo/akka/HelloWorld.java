package Thread.ThreadDemo.akka;/*
package Thread.ThreadDemo.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

*/
/**
 * Created by dell on 2017/3/1.
 *//*

public class HelloWorld extends UntypedActor {
    ActorRef greeter;


    //启动前的初始化
    @Override
    public void preStart() throws Exception {
        greeter=getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("Greeter actor Path: "+greeter.path());
        greeter.tell(Greeter.Msg.GREET,getSelf());
    }

    @Override
    public void onReceive(Object o) throws Exception {
        if (o==Greeter.Msg.GONE){
            greeter.tell(Greeter.Msg.GREET,getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(o);
        }
    }
}
*/
