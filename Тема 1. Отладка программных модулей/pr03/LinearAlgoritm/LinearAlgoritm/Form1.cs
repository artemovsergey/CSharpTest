using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LinearAlgoritm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            double a = Convert.ToDouble(textBox1.Text);
            double b = Convert.ToDouble(textBox2.Text);
            richTextBox1.Text = (Math.Sin(a)+ Math.Cos(b)).ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            double x = Convert.ToDouble(textBox3.Text);
            double y = Convert.ToDouble(textBox4.Text);
            double a;
            if(x/y > 0)
            {
                a = Math.Sin(x + y);
                textBox5.Text = a.ToString();
            }
            else if(x/y < 0)
            {
                a = Math.Cos(x + y);
                textBox5.Text = a.ToString();
            }
            else
            {
                a = x + y;
                textBox5.Text = a.ToString();
            }


        }
    }
}
