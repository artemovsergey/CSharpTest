using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EvaluateStateFigurs
{
    internal class Program
    {
        static void Main(string[] args)
        {

            double St, a, r, Pt, Sc, Pc, S, P;
            Console.WriteLine("Введите сторону:");
            string buf = Console.ReadLine();
            a = Convert.ToDouble(buf);
            Console.WriteLine("Ваша сторона=" + a);
            Console.WriteLine("Введите радиус:");
            string but = Console.ReadLine();
            r = Convert.ToDouble(but);
            Console.WriteLine("Ваш радиус=" + r);
            Sc = ((r * r) * Math.PI) / 8;
            Pc = ((2 * Math.PI) * r) / 8;
            St = (0.5 * (a * a)) - Sc;
            Pt = (a + a + (a = Math.Sqrt(2))) - Pc;
            S = Sc + St;
            P = Pc + Pt;
            Console.WriteLine("Площадь фигуры=" + S);
            Console.WriteLine("Периметр фигуры=" + P);
            Console.ReadKey();

        }
    }
}
