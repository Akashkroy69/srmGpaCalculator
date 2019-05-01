package srmGpaCalculator;

//package srm_frem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sem extends JFrame {
	public JLabel apptitle;

	public JLabel subject[] = new JLabel[20];
	public JTextField t[] = new JTextField[30];
	public Container c;
	static float res = 0;
	static double sum = 0.0, creditSum = 0;

	public Sem() {
		this.setTitle("SRM GPA/CGPA CAL.");
		this.setVisible(true);
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		ImageIcon i = new ImageIcon("f:/Srm.png");
		this.setIconImage(i.getImage());
		this.setContentPane(new JLabel(new ImageIcon("f:/Srm.png")));

		setPar();

	}

	void setPar() {

		// creating MENU.
		MenuBar mb = new MenuBar();
		setMenuBar(mb);

		Menu semester = new Menu("COMPUTER SCIENCE");
		MenuItem i1, i2, i3, i4, i5, i6, i7, i8, hr;

		semester.add(i1 = new MenuItem("SEMESTER 1"));
		semester.add(hr = new MenuItem("-"));
		semester.add(i2 = new MenuItem("SEMESTER 2"));
		semester.add(hr = new MenuItem("-"));
		semester.add(i3 = new MenuItem("SEMESTER 3"));
		semester.add(hr = new MenuItem("-"));

		semester.add(i4 = new MenuItem("SEMESTER 4"));
		semester.add(hr = new MenuItem("-"));
		semester.add(i5 = new MenuItem("SEMESTER 5"));
		semester.add(hr = new MenuItem("-"));
		semester.add(i6 = new MenuItem("SEMESTER 6"));
		semester.add(hr = new MenuItem("-"));
		semester.add(i7 = new MenuItem("SEMESTER 7"));
		semester.add(hr = new MenuItem("-"));
		semester.add(i8 = new MenuItem("SEMESTER 8"));
		// dept.add(semester);
		Menu dept = new Menu("CALCULATE GPA");
		MenuItem xyz, cse, others;
		dept.add(semester);
		dept.add(xyz = new MenuItem("-"));
		dept.add(others = new MenuItem("OTHERS")); /// OTHERS OPTION///

		Menu gp = new Menu("GPA/CGPA CALCULATION");
		MenuItem hr1, gpa, cgpa;
		gp.add(dept);
		gp.add(hr1 = new MenuItem("-"));
		gp.add(cgpa = new MenuItem("CALCULATE CGPA"));
		mb.add(gp);
		// mb.add(dept);

		Font font = new Font("Algerian", Font.BOLD, 20);
		c = this.getContentPane();
		c.setLayout(null);

		apptitle = new JLabel();
		apptitle.setText("SRM GPA/CGPA CALCULATOR");
		apptitle.setFont(font);
		apptitle.setBounds(280, 40, 340, 20);
		c.add(apptitle);

		i1.addActionListener(e -> {
			setSem1();
		});

		i2.addActionListener(e -> {
			setSem2();
		});
		i3.addActionListener(e -> {
			setSem3();
		});

		i4.addActionListener(e -> {
			setSem4();
		});
		i5.addActionListener(e -> {
			setSem5();
		});
		i6.addActionListener(e -> {
			setSem6();
		});

		i7.addActionListener(e -> {
			setSem7();
		});
		i8.addActionListener(e -> {
			setSem8();
		});
		cgpa.addActionListener(e -> {

			setCgpa();

		});
		others.addActionListener(e -> {

			setOthers();
		});

	}

	public void setSem1() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		for (int x = 0; x < 26; x++) {

			t[x] = new JTextField();

		}
		for (int x = 0; x < 17; x++) {

			subject[x] = new JLabel();

		}
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 430, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 430, 50, 20);

		p.add(but);
		p.add(result);
		c.add(p);

		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 17; x++) {
			String s[] = { "SEMESTER 1", "SUBJECT", "GPA", "CREDIT", "1.SOFT SKILL", "2.Val Ed", "3.MatLab",
					"4.CalCulus", "5.Physics", "6.Phy L", "7.Chem", "8.Chem L", "9.Bio", "10 B.C.E", "11 B.E.L",
					"12 H&T", "13 NSS" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 25; xt += 2) {
			int cred[] = { 1, 1, 2, 4, 3, 1, 3, 1, 2, 2, 2, 2, 1 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res = 0;
				sum = 0;
				try

				{
					for (int SI = 0; SI < 26; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println("marks for " + SI + " " + marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println("Credit for " + SI + " " + credit);
						sum = sum + (marks * credit);
						System.out.println("sum for " + (SI - 1) + "Line : " + sum);
						res = (float) (sum / creditSum);
						System.out.println("Result for " + (SI - 1) + "Line  " + res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, "Enter Full Detail.");

				}

			}
		});

	}

	public void setSem2() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 18; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 13; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		c.removeAll();
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 330, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 330, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 13; x++) {
			String s[] = { "SEMESTER 2", "SUBJECT", "GPA", "CREDIT", "1.ENGLISH", "2.SOFT SKILL II", "3.CALCULUS",
					"4.MATERIAL SCIENCE", "5.POE", "6.BME", "7.BEE", "8.ENG GRAPH", "9.C PROG" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 18; xt += 2) {
			int cred[] = { 2, 1, 4, 3, 2, 2, 2, 3, 4 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{
					for (int SI = 0; SI < 18; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println(marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println(credit);
						sum = sum + (marks * credit);
						System.out.println("sum : " + sum);
						res = (float) (sum / creditSum);
						System.out.println(res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, " ENTER FULL DETAIL ");

				}

			}
		});

	}

	public void setSem3() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 20; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 14; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		c.removeAll();
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 330, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 330, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 14; x++) {
			String s[] = { "SEMESTER 3", "SUBJECT", "GPA", "CREDIT", "1.LANG.", "2.APTI I", "3.VALUE PROB.",
					"4.ELECTRIC CIR.", "5.D.C.F", "6.OOP", "7.uPROCESS", "8.OOAD", "9.OOP LAB", "10.u LAB" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 20; xt += 2) {
			int cred[] = { 2, 1, 4, 3, 3, 3, 3, 3, 1, 1 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{
					for (int SI = 0; SI < 20; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println(marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println(credit);
						sum = sum + (marks * credit);
						System.out.println("sum : " + sum);
						res = (float) (sum / creditSum);
						System.out.println(res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, " ENTER FULL DETAIL ");

				}

			}
		});

	}

	public void setSem4() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 22; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 15; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 360, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 360, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 15; x++) {
			String s[] = { "SEMESTER 4", "SUBJECT", "GPA", "CREDIT", "1.LANG II", "2.APTI II", "3.PROBABILITY",
					"4.ELECT.DEVICE", "5.DATA STR", "6.NETWORKS", "7.COA", "8.COMPUTER SKILL", "9.ELECTIVE I",
					"10.D.S LAB", "11.NET LAB" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 22; xt += 2) {
			int cred[] = { 2, 1, 4, 3, 3, 3, 3, 2, 3, 1, 1 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{
					for (int SI = 0; SI < 22; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println(marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println(credit);
						sum = sum + (marks * credit);
						System.out.println("sum : " + sum);
						res = (float) (sum / creditSum);
						System.out.println(res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, " ENTER FULL DETAIL ");

				}

			}
		});

	}

	public void setSem5() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 22; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 15; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 360, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 360, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 15; x++) {
			String s[] = { "SEMESTER 5", "SUBJECT", "GPA", "CREDIT", "1.APTI III", "2.DSCRETE MATH", "3.COM THEORY",
					"4.OS", "5.TOC", "6.DBMS", "7.IND.TRAINING", "8.DEPT ELCTIVE", "9.OPEN ELECTIVE", "10.OS LAB",
					"11.DBMS LAB" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 22; xt += 2) {
			int cred[] = { 1, 4, 3, 3, 3, 3, 1, 3, 3, 1, 1 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{
					for (int SI = 0; SI < 22; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println(marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println(credit);
						sum = sum + (marks * credit);
						System.out.println("sum : " + sum);
						res = (float) (sum / creditSum);
						System.out.println(res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, " ENTER FULL DETAIL ");

				}

			}
		});

	}

	public void setSem6() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 20; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 14; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 360, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 360, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 14; x++) {
			String s[] = { "SEMESTER 6", "SUBJECT", "GPA", "CREDIT", "1.APTI IV", "2.STATICS", "3.CONTROL SYS",
					"4.SOFT ENG.", "5.COMPILER DESIGN", "6.MINI PROJ", "7.DPT.ELECTIVE II", "8.OPEN ELCTIVE II",
					"9.OPEN ELECTIVE III", "10.OS LAB", "11.COMPILER DESIGN LAB" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 20; xt += 2) {
			int cred[] = { 1, 4, 3, 3, 3, 2, 3, 3, 3, 1 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{
					for (int SI = 0; SI < 20; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println(marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println(credit);
						sum = sum + (marks * credit);
						System.out.println("sum : " + sum);
						res = (float) (sum / creditSum);
						System.out.println(res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, " ENTER FULL DETAIL ");

				}

			}
		});

	}

	public void setSem7() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 16; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 12; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 360, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 360, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 12; x++) {
			String s[] = { "SEMESTER 7", "SUBJECT", "GPA", "CREDIT", "1.MANAGEMENT", "2.AI", "3.WEB TECH",
					"4.INDUST.TRANING", "5.COMPILER DESIGN", "6.DPT.ELECTIVE IV", "7.DEPT ELECTIVE V", "8.AI LAB",
					"9.WEB TECH LAB" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 16; xt += 2) {
			int cred[] = { 3, 3, 3, 1, 3, 3, 1, 1 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{
					for (int SI = 0; SI < 16; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println(marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println(credit);
						sum = sum + (marks * credit);
						System.out.println("sum : " + sum);
						res = (float) (sum / creditSum);
						System.out.println(res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, " ENTER FULL DETAIL ");

				}

			}
		});

	}

	public void setSem8() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 2; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 5; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 360, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 360, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 5; x++) {
			String s[] = { "SEMESTER 8", "SUBJECT", "GPA", "CREDIT", "1.PROJECT " };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				}

			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 1; xt += 2) {

			creditSum = 12;
			t[xt].setText("" + (int) creditSum);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{

					double marks = Double.parseDouble(t[0].getText());
					System.out.println(marks);
					double credit = Double.parseDouble(t[1].getText());
					System.out.println(credit);
					sum = sum + (marks * credit);
					System.out.println("sum : " + sum);
					res = (float) (sum / creditSum);
					System.out.println(res);

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, "ENTER FULL DETAIL ");

				}

			}
		});

	}

	public void setCgpa() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		/// INITIALISING TEXTFIELD
		for (int x = 0; x < 16; x++) {

			t[x] = new JTextField();

		}
		/// INITIALISING JLABEL OBJECT.
		for (int x = 0; x < 12; x++) {

			subject[x] = new JLabel();

		}

		sum = 0.0;
		creditSum = 0;
		res = 0;
		c.removeAll();
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 330, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 330, 50, 20);
		p.add(but);
		p.add(result);
		c.add(p);
		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 12; x++) {
			String s[] = { " CGPA ", "SUBJECT", "GPA", "CREDIT", "SEMESTER 1", "SEMESTER 2", "SEMESTER 3", "SEMESTER 4",
					"SEMESTER 5", "SEMESTER 6", "SEMESTER 7", "SEMESTER 8" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 16; xt += 2) {
			int cred[] = { 25, 23, 24, 26, 26, 26, 18, 12 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			System.out.println(" credit sum is " + creditSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				res = 0;
				try

				{
					for (int SI = 0; SI < 17; SI += 2) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println(marks);

						sum = sum + marks;
						System.out.println("sum : " + sum);
						res = (float) (sum / creditSum);
						System.out.println(res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, " ENTER FULL DETAIL ");

				}

			}
		});
	}

	public void setOthers() {
		int width = 70, height = 20, xc = 20, yc = 20, z1 = 0, crd = 0;

		for (int x = 0; x < 30; x++) {

			t[x] = new JTextField();

		}
		for (int x = 0; x < 19; x++) {

			subject[x] = new JLabel();

		}
		JPanel p = new JPanel();
		JButton but = new JButton("CALCULATE ");
		but.setBounds(10, 430, 110, 20);
		JTextField result = new JTextField("GPA");
		result.setBounds(125, 430, 50, 20);

		p.add(but);
		p.add(result);
		c.add(p);

		p.setLayout(null);
		p.setBackground(new Color(214, 214, 214));
		p.setBounds(10, 100, 270, 500);
		for (int x = 0; x < 17; x++) {
			String s[] = { "GPA CALCULATOR", "SUBJECT", "GPA", "CREDIT", "1.", "2.", "3.", "4.", "5.", "6.", "7.", "8.",
					"9.", "10", "11", "12", "13", "14", "15" };

			subject[x].setText(s[x]);

			if (x == 0) {
				subject[x].setFont(new Font("Algerian", Font.ITALIC, 20));
				subject[x].setBounds(xc + 40, yc, width + 70, height);
				p.add(subject[x]);

			} else if (x >= 1 && x <= 3) {
				subject[x].setBounds(xc, yc + 20, width, height);
				p.add(subject[x]);
				xc += 75;

			} else {
				xc = 20;
				if (x == 4) {
					yc = 70;
					subject[x].setBounds(xc, yc, width, height);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);
					p.add(t[z1++]);

					p.add(subject[x]);
				} else {
					yc += 25;
					subject[x].setBounds(xc, yc, width, height);
					p.add(subject[x]);
					t[z1].setBounds(xc + 75, yc, width, height);
					p.add(t[z1++]);
					t[z1].setBounds(xc + 150, yc, width, height);

					p.add(t[z1++]);

				}
			}

		}

		/// SET-CREDIT ///
		for (int xt = 1; xt <= 30; xt += 2) {
			int cred[] = { 1, 1, 2, 4, 3, 1, 3, 1, 2, 2, 2, 2, 1 };
			creditSum = creditSum + cred[crd];
			t[xt].setText("" + cred[crd++]);
			// System.out.println(crSum);
		}

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res = 0;
				sum = 0;
				try

				{
					for (int SI = 0; SI < 26; SI++) {

						double marks = Double.parseDouble(t[SI].getText());
						System.out.println("marks for " + SI + " " + marks);
						double credit = Double.parseDouble(t[++SI].getText());
						System.out.println("Credit for " + SI + " " + credit);
						sum = sum + (marks * credit);
						System.out.println("sum for " + (SI - 1) + "Line : " + sum);
						res = (float) (sum / creditSum);
						System.out.println("Result for " + (SI - 1) + "Line  " + res);
					}

					result.setText(res + "");

				} catch (NumberFormatException nf)

				{

					JOptionPane.showMessageDialog(c, "Enter Full Detail.");

				}

			}
		});

	}

}
