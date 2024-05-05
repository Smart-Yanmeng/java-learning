package com.york.principles.demo05;

public class Client {

    public static void main(String[] args) {

        Agent agent = new Agent();

        Star star = new Star("cxk");
        agent.setStar(star);

        Fans fans = new Fans("粉丝");
        agent.setFans(fans);

        Company company = new Company("公司");
        agent.setCompany(company);

        agent.meeting();
        agent.business();
    }
}
