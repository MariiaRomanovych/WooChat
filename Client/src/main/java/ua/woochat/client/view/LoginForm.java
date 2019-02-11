package ua.woochat.client.view;

import ua.woochat.client.listeners.LoginFormListener;

import javax.swing.*;
import java.awt.*;

/**
 * Class describes the login form of WooChat application
 * @autor Yevhen Yermolenko, Maryia Romanovych, Sergey Skidan
 */

public class LoginForm {

    private JFrame loginWindow;
    private JTextField userName;
    private JTextField userPassword;

    private JLabel newLoginText;
    private JLabel newPasswordText;
    private JLabel newConfirmPasswordText;
    private JTextField newLogin;
    private JTextField newPassword;
    private JTextField newConfirmPassword;

    private JLabel dummyComponent;
    private JLabel newUserDummyComponent;
    private JPanel loginPanel;
    private JPanel registrationPanel;
    private WindowProperties properties;
    private WindowImages images;
    private LoginFormListener loginFormListener;

    public LoginForm(WindowProperties properties, WindowImages images){
        this.properties = properties;
        this.images = images;

        createWindow();
    }
/**
 *The method describes the size and characteristics of the window
 */

    private void createWindow() {
        loginWindow = new JFrame("Login chat");
        loginWindow.getContentPane().setBackground(properties.getBgColor());
        loginWindow.setBounds(500, 200, 250, 300);
        loginWindow.setLocationRelativeTo(null);
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginWindow.setResizable(false);

        /**
         * Create window logo
         */

        JLabel logo = new JLabel();
        logo.setIcon(images.getLogoImage());

        JLabel userNameText = new JLabel("Account:");
        JLabel userPasswordText = new JLabel("Password:");

        userNameText.setForeground(properties.getTextColor());
        userPasswordText.setForeground(properties.getTextColor());

        /**
         * Create login panel
         */

        loginPanel = new JPanel();
        loginPanel.setBackground(properties.getBgColor());
        loginPanel.setLayout(new FlowLayout());

        userName = new JTextField(20);
        userPassword = new JTextField(20);

        dummyComponent = new JLabel();
        dummyComponent.setPreferredSize(new Dimension(200,15));

        JButton signInButton = new JButton("Sign in");
        JButton registerButton = new JButton("Register");

        btnConfig(signInButton);
        btnConfig(registerButton);

        signInButton.setActionCommand("signInButton");
        registerButton.setActionCommand("registerButton");

        loginPanel.add(logo);
        loginPanel.add(userNameText);
        loginPanel.add(userName);
        loginPanel.add(userPasswordText);
        loginPanel.add(userPassword);
        loginPanel.add(dummyComponent);
        loginPanel.add(signInButton);
        loginPanel.add(registerButton);

        /**
         * Create registration panel
         */
        registrationPanel = new JPanel();
        registrationPanel.setBackground(properties.getBgColor());
        registrationPanel.setLayout(new FlowLayout());

        JLabel newUserLogo = new JLabel();
        newUserLogo.setIcon(images.getNewUserLogo());

        newLoginText = new JLabel("User name:");
        newPasswordText = new JLabel("Password:");
        newConfirmPasswordText = new JLabel("Confirm password:");

        newUserDummyComponent = new JLabel();
        newUserDummyComponent.setPreferredSize(new Dimension(200,15));

        newLoginText.setForeground(properties.getTextColor());
        newPasswordText.setForeground(properties.getTextColor());
        newConfirmPasswordText.setForeground(properties.getTextColor());

        newLogin = new JTextField(20);
        newPassword = new JTextField(20);
        newConfirmPassword = new JTextField(20);

        JButton newUserButton = new JButton("Create");
        JButton cancelNewUserButton = new JButton("Cancel");

        btnConfig(newUserButton);
        btnConfig(cancelNewUserButton);

        newUserButton.setActionCommand("create");
        cancelNewUserButton.setActionCommand("cancel");


        registrationPanel.add(newUserLogo);
        registrationPanel.add(newLoginText);
        registrationPanel.add(newLogin);
        registrationPanel.add(newPasswordText);
        registrationPanel.add(newPassword);
        registrationPanel.add(newConfirmPasswordText);
        registrationPanel.add(newConfirmPassword);
        registrationPanel.add(newUserDummyComponent);
        registrationPanel.add(newUserButton);
        registrationPanel.add(cancelNewUserButton);

        loginWindow.getContentPane().add(loginPanel);

        /**
         * adding action listener
         */

        loginFormListener = new LoginFormListener(this);

        signInButton.addActionListener(loginFormListener);
        registerButton.addActionListener(loginFormListener);
        newUserButton.addActionListener(loginFormListener);
        cancelNewUserButton.addActionListener(loginFormListener);

        loginWindow.setVisible(true);
    }

    /**
     * methods configure the buttons. Also the class defines the listener for each button.
     * @param btn JButton components
     */

    private void btnConfig(JButton btn) {
        btn.setPreferredSize(new Dimension(100,25));
        btn.setBackground(properties.getBtnColor());
        btn.setBorderPainted(false);
        btn.addActionListener(loginFormListener);
    }

    public JFrame getLoginWindow() {
        return loginWindow;
    }

    public void setLoginWindow(JFrame loginWindow) {
        this.loginWindow = loginWindow;
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public JPanel getRegistrationPanel() {
        return registrationPanel;
    }

    public void setRegistrationPanel(JPanel registrationPanel) {
        this.registrationPanel = registrationPanel;
    }
}
