package com.longshihan.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by dell on 2017/2/10.
 */
public class App extends ClassLoader implements Opcodes {
    public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, InstantiationException {
        ClassReader cr=new ClassReader(HelloWorld.class.getName());
        ClassWriter cw=new ClassWriter(ClassWriter.COMPUTE_MAXS);
        CustomVisitor myv=new CustomVisitor(Opcodes.ASM4,cw);
        cr.accept(myv, 0);

        byte[] code=cw.toByteArray();

        //自定义加载器
        App loader=new App();
        Class<?> appClass=loader.defineClass(null, code, 0,code.length);
        appClass.getMethods()[0].invoke(appClass.newInstance(), new Object[]{});

//		FileOutputStream f=new FileOutputStream(new File("d:"+File.separator+"ok2.class"));
//		f.write(code);;
//		f.close();

    }
}
