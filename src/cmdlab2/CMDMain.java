package cmdlab2;

public class CMDMain {
    
    public static void main(String[] args) {
        CMDLogic cmdlogic = new CMDLogic();
        CMD cmd = new CMD(cmdlogic);
        cmd.setVisible(true);
        
    }
    
    
    
}
