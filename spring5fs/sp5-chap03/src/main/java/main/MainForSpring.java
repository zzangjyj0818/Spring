package main;
import Assembler.Assembler;
import config.AppCtx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.*;

import java.io.*;
public class MainForSpring {
    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException{
        ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Input the Command:");
            String command = reader.readLine();
            if(command.equalsIgnoreCase("exit")){
                System.out.println("Exit the Program");
                break;
            }
            if(command.startsWith("new ")){
                processNewCommand(command.split(" "));
                continue;
            }else if(command.startsWith("change ")){
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] arg){
        if(arg.length != 5){
            printHelp();
            return;
        }
        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("암호와 확인이 일치하지 않습니다.");
            return;
        }

        try{
            regSvc.regist(req);
            System.out.println("등록했습니다.");
        }catch (DuplicateMemberException e){
            System.out.println("이미 존재하는 이메일입니다");
        }
    }

    private static void processChangeCommand(String[] arg){
        if(arg.length != 4){
            printHelp();
            return;
        }
        ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
        try{
            changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호를 변경했습니다.");
        }catch (MemberNotFoundException e){
            System.out.println("존재하지 않는 이메일 입니다.");
        }catch (WrongIdPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다.");
        }
    }

    private static void printHelp(){
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
        System.out.print("명령어 사용법 : new 이메일 이름 암호 암호확인\n");
        System.out.print("change 이메일 현재비번 변경비번");
        System.out.println();
    }
}
