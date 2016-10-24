package com.player.otherclasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlayerGUI implements ActionListener{

	private JFrame frmMpplayer;
	private JLabel lblNowPlaying;
	private JLabel lblFileName;
	private JButton btnOpen;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnStop;
	private PlayerMethods playerMethods = new PlayerMethods();
	private File selectedFile; 
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		PlayerGUI window = new PlayerGUI();
		window.frmMpplayer.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public PlayerGUI() {
		createGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createGUI() {
		frmMpplayer = new JFrame();
		frmMpplayer.setTitle("My MP3 player");
		frmMpplayer.setBounds(100, 100, 589, 189);
		frmMpplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpplayer.getContentPane().setLayout(null);
		
		lblNowPlaying = new JLabel("Now playing:");
		lblNowPlaying.setBounds(12, 12, 107, 15);
		
		lblFileName = new JLabel("");
		lblFileName.setBounds(117, 12, 435, 15);
		
		btnOpen = new JButton("Open");
		btnOpen.setBounds(44, 81, 117, 25);
		
		btnPlay = new JButton("Play");
		btnPlay.setBounds(179, 81, 117, 25);
		
		btnPause = new JButton("Pause");
		btnPause.setBounds(308, 81, 117, 25);
		
		btnStop = new JButton("Stop");
		btnStop.setBounds(437, 81, 117, 25);
	}
	
	/**
	 * 
	 */
	private void addComponentsToFrame() {
		frmMpplayer.getContentPane().add(lblNowPlaying);
		frmMpplayer.getContentPane().add(lblFileName);
		frmMpplayer.getContentPane().add(btnOpen);
		frmMpplayer.getContentPane().add(btnPlay);
		frmMpplayer.getContentPane().add(btnPause);
		frmMpplayer.getContentPane().add(btnStop);
	}

	/**
	 * 
	 */
	public void addActionListeners(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);		
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			int returnVal = fileChooser.showOpenDialog(frmMpplayer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();				
				lblFileName.setText(selectedFile.getName());
			}			
		}
		if (e.getSource() == btnPlay) {
			playerMethods.play(selectedFile);
		}
		if (e.getSource() == btnPause) {
			playerMethods.pause();
		}
		if (e.getSource() == btnStop) {
			playerMethods.stop();
		}
		
	}
}

