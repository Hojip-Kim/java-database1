package study.db;

import java.util.Scanner;

public class DbTestMain {

    public static void main(String[] args) {

        memberService memberService = new memberService();
//        dbTest.dbSelect();
//        dbTest.dbInsert();
//        dbTest.dbUpdate();
//        dbTest.dbDelete();



        Scanner scanner = new Scanner(System.in);


        System.out.println("탈퇴할 회원 아이디를 입력해주세요 : >>>");

            String userId = scanner.next();
        String memberType = scanner.next();


//
//            String memberType = "email";
//        System.out.println("Please typing Id : >>>");
//            String userId = scanner.next();
//        System.out.println("Please typing password : >>>");
//            String password = scanner.next();
//        System.out.println("Please typing name : >>>");
//            String name = scanner.next();

        Member member = new Member();

        member.setMemberType(memberType);
        member.setUserId(userId);
//        member.setPassword(password);
//        member.setName(name);

//            memberService.register(member);
                memberService.withdraw(member);
    }


}
