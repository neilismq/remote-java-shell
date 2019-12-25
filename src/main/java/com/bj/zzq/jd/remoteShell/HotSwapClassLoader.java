package com.bj.zzq.jd.remoteShell;

/**
 * 为了多次载入执行类而加入的加载器
 * 把defineClass方法开放出来，只有外部显示调用时的时候才会使用到loadByte方法
 * 由虚拟机调用时,仍然按照原有的双亲委派规则使用loadClass方法进行类加载
 *
 * @author zhaozhiqiang35
 * @date 2019-12-24 20:41
 */
public class HotSwapClassLoader extends ClassLoader {

    //设置当前的类加载器的父加载器是加载这个类的类加载器
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
