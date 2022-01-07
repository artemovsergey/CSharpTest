def AddContact():
    #Runs the "main" tested application.
    TestedApps.main.Run()
    #Clicks the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.TkChild.Click(71, 8)
    #Enters 'Andrew' in the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.Keys("Andrew")
    #Clicks the 'TkChild2' object.
    Aliases.main.wndTkTopLevel.TkChild.TkChild2.Click(65, 8)
    #Enters '76546385743' in the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.Keys("76546385743")
    #Clicks the 'btn' button.
    Aliases.main.wndTkTopLevel.TkChild.btn.ClickButton()
    #Clicks the 'btn_' button.
    Aliases.main.dlgResult.btn_.ClickButton()
    #Clicks the 'btn2' button.
    Aliases.main.wndTkTopLevel.TkChild.btn2.ClickButton()
    
    s = aqFile.ReadWholeTextFile("C:\\Users\\svt\\PycharmProjects\\pytestpr4\\dist\\main\\contactBook.txt", aqFile.ctANSI)
    Log.Message(s)
    
    #Runs the "NOTEPAD" tested application.
    #TestedApps.NOTEPAD.Run(1, True)
    #Maximizes the 'wndNotepad' window.
    #Aliases.notepad.wndNotepad.Maximize()
    #Closes the 'wndNotepad' window.
    #Aliases.notepad.wndNotepad.Close()

def SearchPhoneNumber():
    #Runs the "main" tested application.
    TestedApps.main.Run()
    #Clicks the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.TkChild.Click(83, 15)
    #Enters 'Andrew' in the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.Keys("Andrew")
    #Clicks the 'btn3' button.
    Aliases.main.wndTkTopLevel.TkChild.btn3.ClickButton()
    #Clicks the 'btn_' button.
    Aliases.main.dlgSearch.btn_.ClickButton()
    #Clicks the 'btn2' button.
    Aliases.main.wndTkTopLevel.TkChild.btn2.ClickButton()

def ShowPhoneNumber():
    #Runs the "main" tested application.
    TestedApps.main.Run()
    #Clicks the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.TkChild.Click(44, 11)
    #Clicks the 'btn4' button.
    Aliases.main.wndTkTopLevel.TkChild.btn4.ClickButton()
    #Clicks the 'btn_' button.
    Aliases.main.dlgPhoneNumberList.btn_.ClickButton()
    
    s = aqFile.ReadWholeTextFile("C:\\Users\\svt\\PycharmProjects\\pytestpr4\\dist\\main\\contactBook.txt", aqFile.ctANSI)
    Log.Message(s)

def RemovePhoneNumber():
    #Clicks the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.TkChild.Click(70, 13)
    #Enters 'Andrew' in the 'TkChild' object.
    Aliases.main.wndTkTopLevel.TkChild.Keys("Andrew")
    #Clicks the 'btn5' button.
    Aliases.main.wndTkTopLevel.TkChild.btn5.ClickButton()
    #Clicks the 'btn_2' button.
    Aliases.main.dlgResult.btn_2.ClickButton()
    #Clicks the 'btn_' button.
    Aliases.main.dlgResult2.btn_.ClickButton()
    #Clicks the 'btn2' button.
    Aliases.main.wndTkTopLevel.TkChild.btn2.ClickButton()
    
    s = aqFile.ReadWholeTextFile("C:\\Users\\svt\\PycharmProjects\\pytestpr4\\dist\\main\\contactBook.txt", aqFile.ctANSI)
    Log.Message(s)

def AddContact_BigData():
    Project.Variables.AddContact.Reset()
    while not Project.Variables.AddContact.IsEOF():
        #Runs the "main" tested application.
        TestedApps.main.Run()
        #Clicks the 'TkChild' object.
        Aliases.main.wndTkTopLevel.TkChild.Click(168, 29)
        #Clicks the 'TkChild' object.
        Aliases.main.wndTkTopLevel.TkChild.TkChild.Click(44, 12)
        #Enters KeywordTests.Test1.Variables.AddContact["name"] in the 'TkChild' object.
        Aliases.main.wndTkTopLevel.TkChild.Keys(Project.Variables.AddContact.Value["name"])
        #Clicks the 'TkChild2' object.
        Aliases.main.wndTkTopLevel.TkChild.TkChild2.Click(42, 17)
        #Enters KeywordTests.Test1.Variables.AddContact["phone"] in the 'TkChild' object.
        Aliases.main.wndTkTopLevel.TkChild.Keys(Project.Variables.AddContact.Value["phone"])
        #Clicks the 'btn' button.
        Aliases.main.wndTkTopLevel.TkChild.btn.ClickButton()
        #Clicks the 'btn_' button.
        Aliases.main.dlgResult.btn_.ClickButton()
        #Closes the 'wndTkTopLevel' window.
        Aliases.main.wndTkTopLevel.Close()
        #Runs the "main" tested application.
        TestedApps.main.Run(1, True)
        Project.Variables.AddContact.Next()
        
        s = aqFile.ReadWholeTextFile("C:\\Users\\svt\\PycharmProjects\\pytestpr4\\dist\\main\\contactBook.txt", aqFile.ctANSI)
        Log.Message(s)

def ViewTextFile():
    #Runs the "NOTEPAD" tested application.
    TestedApps.NOTEPAD.Run(1, True)
    #Maximizes the 'wndNotepad' window.
    Aliases.notepad.wndNotepad.Maximize()
