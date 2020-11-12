package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import type.TypeFile;
import view.MainView;

public class Main {

	public static void main(String[] args) throws Exception {
		JDialog chooseFormat = new JDialog();
		chooseFormat.setSize(new Dimension(400, 400));
		chooseFormat.setLocationRelativeTo(null);
		JButton json = new JButton("JSON"),yml = new JButton("YML"),cbw = new JButton("CBW");
		
		json.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File folder = new File("data/JSON");
				JComboBox<String> filesBox = new JComboBox<String>();
				File[] listOfFiles = folder.listFiles();
				for (File f : listOfFiles) {
					StringBuilder sb = new StringBuilder("data/JSON");
					sb.append("/");
					sb.append(f.getName());
					filesBox.addItem(sb.toString());
				}
				chooseFormat.dispose();
				JDialog files = new JDialog();
				files.add(filesBox,BorderLayout.CENTER);
				JButton butt = new JButton("OK");
				
				butt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String filepath = filesBox.getSelectedItem().toString();
						try {
							MainView.getInstance(TypeFile.JSON,filepath);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						files.dispose();
					}
				});
				
				files.add(butt,BorderLayout.SOUTH);
				files.setSize(new Dimension(400,400));
				files.setLocationRelativeTo(null);
				files.setVisible(true);
			}
		});
		
		yml.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					File folder = new File("data/YML");
					JComboBox<String> filesBox = new JComboBox<String>();
					File[] listOfFiles = folder.listFiles();
					for (File f : listOfFiles) {
						filesBox.addItem(f.getAbsolutePath());
					}
					chooseFormat.dispose();
					JDialog files = new JDialog();
					files.add(filesBox,BorderLayout.CENTER);
					JButton butt = new JButton("OK");
					
					butt.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String filepath = filesBox.getSelectedItem().toString();
							try {
								MainView.getInstance(TypeFile.YML,filepath);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							files.dispose();
						}
					});
					
					files.add(butt,BorderLayout.SOUTH);
					files.setSize(new Dimension(400,400));
					files.setLocationRelativeTo(null);
					files.setVisible(true);
				}
			});
	cbw.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					File folder = new File("data/CBW");
					JComboBox<String> filesBox = new JComboBox<String>();
					File[] listOfFiles = folder.listFiles();
					for (File f : listOfFiles) {
						filesBox.addItem(f.getAbsolutePath());
					}
					chooseFormat.dispose();
					JDialog files = new JDialog();
					files.add(filesBox,BorderLayout.CENTER);
					JButton butt = new JButton("OK");
					
					butt.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String filepath = filesBox.getSelectedItem().toString();
							try {
								MainView.getInstance(TypeFile.CBW,filepath);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							files.dispose();
						}
					});
					
					files.add(butt,BorderLayout.SOUTH);
					files.setSize(new Dimension(400,400));
					files.setLocationRelativeTo(null);
					files.setVisible(true);
				}
			});
		
		
		
		chooseFormat.add(json);
		chooseFormat.add(yml);
		chooseFormat.add(cbw);
		chooseFormat.setLayout(new GridLayout(1,3));
		chooseFormat.setVisible(true);

	}

}
