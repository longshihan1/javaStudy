package spi;

import java.util.ServiceLoader;

public class TestService {
    public static void main(String[] args) {
        ServiceLoader<IService> serviceLoader = ServiceLoader.load(IService.class);
        for (IService myServiceLoader : serviceLoader){
            System.out.println(myServiceLoader.getScheme() + myServiceLoader.sayHello());
        }
    }
}
