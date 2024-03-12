module module.a {
    // 导出 module a 下的 animal 让外部通过任意访问
    exports com.qztc.module.a.animal;

    // 导出 module a 下的 person 让外部仅通过反射的方式访问
    opens com.qztc.module.a.person;
}
