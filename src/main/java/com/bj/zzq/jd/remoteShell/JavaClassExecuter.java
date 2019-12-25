package com.bj.zzq.jd.remoteShell;

import java.lang.reflect.Method;

/**
 * 请填写类的描述
 *
 * @author zhaozhiqiang35
 * @date 2019-12-24 21:11
 */
public class JavaClassExecuter {


    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        //修改字节码
        ClassModifier cm = new ClassModifier(classByte);
        //替换系统的System为自定义的类
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "com/bj/zzq/jd/remoteShell/HackSystem");
        //每次都重新实现了类加载器实例，所以可以重复的加载测试类
        HotSwapClassLoader loader = new HotSwapClassLoader();
        //加载，通过这个方法，避开了双亲委托模式
        Class clz = loader.loadByte(modiBytes);

        try {
            //反射调用入口方法
            Method method = clz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return HackSystem.getBufferString();
    }

}



