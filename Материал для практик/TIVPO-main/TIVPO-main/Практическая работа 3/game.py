import random

class Game:

    def get_question(self):
        with open('q.txt', 'r', encoding='utf-8') as f:
            question_list = f.read().splitlines()
        number_question = random.randrange(0, len(question_list))
        question_answer = str(question_list[number_question])
        for i in range(0, len(question_answer)):
            if question_answer[i] == ';':
                answer = question_answer[i + 1:len(question_answer)]
                question = question_answer[0:i]
        return question, answer

    def outputinfo(self, answer):
        curent_view = []
        for i in range(0,len(answer)):
            curent_view.append('*')
        print(''.join(curent_view))

        while True:
            user = input('Введите букву или назовите слово сразу: ')
            if user == answer:
                print('Вы правильно назвали слово!');break
            if (user in answer):
                print('Есть такая буква в этом слове!')
                for i in range(0,len(answer)):
                    if answer[i]==user:
                        curent_view[i]=user
                        user_answer = ''.join(curent_view)
            else:
                print('Такой буквы нет!')
            if user_answer == answer:
                print('Вы правильно назвали все буквы!');break
            print(user_answer)

class Player:
    def __init__(self, name, age, motto_in_life):
        self.name = name
        self.age = age
        self.motto_in_life = motto_in_life

    def player_info(self):
        print(f'\nИнформация об игроке: \n Имя: {self.name}, \n Возраст: {self.age}, \n Девиз по жизни: {self.motto_in_life}\n')

class Menu:

    def menu(self):
        print(
            '\n====== Капитан-Шоу "Поле Чудес" ======\n 1 - Начать игру \n 2 - Об игроке \n 3 - Об игре \n 0 - Выход \n')
        code = int(input('Выберите пункт: '))
        if code == 1:
            new_game = Game()
            que, ans = new_game.get_question()
            print(que)
            print(new_game.outputinfo(ans))
        elif code == 0:
            exit('\nИгра завершена')
        elif code == 2:
            print('Перед началом игры заполните поля: \n')
            name = input('Введите свое имя: ')
            age = int(input('Введите свой возраст: '))
            motto_in_life = input('Введите девиз по жизни: ')
            if name and age and motto_in_life:
                new_player = Player(name, age, motto_in_life)
            print(new_player.player_info())
        elif code == 3:
            print('\nИгра разработана черезе TDD\n')
        else:
            print('Нет такого пункта меню, повторите попытку.')
            menu = Menu()

if __name__ == '__main__':
    menu = Menu()
    menu.menu()
# new_player = Player('Андрей', 20, 'Все к лучшему!')
# new_player.player_info()

# new_game = Game()
# que, ans = new_game.get_question()
# print(que)
# print(new_game.outputinfo(ans))