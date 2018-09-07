package Thread.ThreadDemo.akka;/*
package Thread.ThreadDemo.akka;

import akka.actor.UntypedActor;

*/
/**
 * Created by dell on 2017/3/1.
 *//*

public class Greeter extends UntypedActor {
    public static enum Msg {
        GREET, GONE
    }

    @Override
    public void onReceive(Object o) throws Exception {
        if (o == Msg.GREET) {
            System.out.println("Hello world!");
            getSender().tell(Msg.GONE, getSelf());
        } else {
            unhandled(o);
        }
    }
}
*/
