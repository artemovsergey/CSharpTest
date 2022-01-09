using NUnit.Framework;
using System;
using _1_1;

//� Production Code �������� ����� FileService � ������� int MergeTemporaryFiles(string
//dir). � ������ ������ ����� ���������� � ���������� dir � ��������� �� ���� ������ �
//����������� .tmp � ������ ���������� ���� ���� backup.tmp (�������
//�������������), ����� ���� ������� ��� �������� �����. ����� ���������� ����������
//�������� ������; ���� ������� ���� ��������������� ��������, ������ ���� �������
//����������. ������ ����� ������ ����������, � ���� �������, �� ������
//PrepareData() ������ ReportViewer.���� ����� ������ ����� ���������� ����������,
//���� ���������� �������� ������ ���� ����� ����; ����� � ��������� ��������
//BlockCount ������ ReportViewer ��� ����������. �������������� ��� ��������.

namespace _1_1_Tests
{
    public class ReportViewerWithStubTests
    {
        IFileAccesser _fa;
        _1_1.ReportViewer _rv;

        [Test]
        public void DirectoryDoesntExistException()
        {
            _fa = new Classes.StubMergeTemporaryFiles(null);
            _rv = new _1_1.ReportViewer(_fa);

            Assert.Throws<ArgumentException>(() => _rv.PrepareData("dir"));
        }

        [Test]
        public void DirectoryIsEmptyException()
        {
            _fa = new Classes.StubMergeTemporaryFiles(new string[] { });
            _rv = new _1_1.ReportViewer(_fa);

            Assert.Throws<ArgumentException>(() => _rv.PrepareData("dir"));
        }

        [Test]
        public void DirectoryWithFiles_CountReturns()
        {
            _fa = new Classes.StubMergeTemporaryFiles(new string[] { "1.tmp", "2.tmp"});
            _rv = new _1_1.ReportViewer(_fa);
            _rv.PrepareData("dir");

            Assert.That(_rv.BlockCount, Is.EqualTo(2));
        }

    }
}
