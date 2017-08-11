/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientessh;
import com.jcraft.jsch.*;

/**
 *
 * @author leandro
 */
public class ClienteSSH implements UserInfo {
    
     @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public boolean promptPassword(String string) {
        return true;
    }

    @Override
    public boolean promptPassphrase(String string) {
        return true;
    }

    @Override
    public boolean promptYesNo(String string) {
        return true;
    }

    @Override
    public void showMessage(String string) {
        System.err.println("conectado!!!");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSchException {
        // TODO code application logic here
        try{
            JSch jsch = new JSch();
            Session session = jsch.getSession("root", "192.168.0.100", 22);
            session.setPassword("");
            session.setUserInfo(new ClienteSSH());
            session.connect(30000);
            
            Channel channel = session.openChannel("shell");
            channel.setInputStream(System.in);
            
            channel.setOutputStream(System.out);
            //channel.setCommand("mkdir filipe");
            channel.connect(3*1000);
            //channel.disconnect();
            
        }catch(JSchException js){
            
        }
    }
}
