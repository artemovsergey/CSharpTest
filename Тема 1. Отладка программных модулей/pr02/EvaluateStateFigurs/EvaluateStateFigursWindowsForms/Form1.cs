using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EvaluateStateFigursWindowsForms
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
            double St, a, r, Pt, Sc, Pc, S, P;

            r = Convert.ToDouble(textBox1.Text);
            a = Convert.ToDouble(textBox2.Text);


            Sc = ((r * r) * Math.PI) / 8;
            Pc = ((2 * Math.PI) * r) / 8;
            St = (0.5 * (a * a)) - Sc;
            Pt = (a + a + (a = Math.Sqrt(2))) - Pc;
            S = Sc + St;
            P = Pc + Pt;


            textBox3.Text = S.ToString();
            textBox4.Text = P.ToString();

        }
    }
}
