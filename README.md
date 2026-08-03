# PasswordGenerator

Утилита для генерации и проверки надёжности паролей.

## Функции

### generatePassword

Генерирует пароль заданной длины с использованием псевдослучайного генератора.

```java
String password = PasswordGenerator.generatePassword(length, seed, useUppercase, useDigits, useSpecial);
```

**Параметры:**

| Параметр       | Тип      | Описание                              |
|----------------|----------|---------------------------------------|
| `length`       | int      | Длина пароля                          |
| `seed`         | long     | Ключ генератора                       |
| `useUppercase` | boolean  | Включить заглавные буквы (A-Z)        |
| `useDigits`    | boolean  | Включить цифры (0-9)                  |
| `useSpecial`   | boolean  | Включить спецсимволы (!@#$%^&*)       |

**Наборы символов:**

- Строчные буквы: `abcdefghijklmnopqrstuvwxyz` (всегда)
- Заглавные буквы: `ABCDEFGHIJKLMNOPQRSTUVWXYZ` (опционально)
- Цифры: `0123456789` (опционально)
- Спецсимволы: `!@#$%^&*` (опционально)

### checkPassword

Проверяет надёжность пароля по пяти критериям.

```java
String result = PasswordGenerator.checkPassword(password);
```

**Критерии оценки:**

1. Длина не менее 8 символов
2. Наличие строчной латинской буквы
3. Наличие заглавной латинской буквы
4. Наличие цифры
5. Наличие спецсимвола

**Вердикты:**

| Оценка | Вердикт   |
|--------|-----------|
| 5      | Сильный   |
| 4      | Хороший   |
| 3      | Средний   |
| 0-2    | Слабый    |

## Примеры

### Генерация паролей

```java
System.out.println("буквы и цифры:    " + PasswordGenerator.generatePassword(12, 123L, true, true, false));
System.out.println("со спецсимволами: " + PasswordGenerator.generatePassword(16, 7L, true, true, true));
```

**Вывод:**

```
буквы и цифры:    5vjehYzZEzZ0
со спецсимволами: 9#!qGz1Yb@T&nK2j
```

### Проверка надёжности

```java
System.out.println("abc        -> " + PasswordGenerator.checkPassword("abc"));
System.out.println("abcdef1234 -> " + PasswordGenerator.checkPassword("abcdef1234"));
System.out.println("Abcdef123! -> " + PasswordGenerator.checkPassword("Abcdef123!"));
```

**Вывод:**

```
abc        -> Слабый пароль (оценка 1 из 5)
abcdef1234 -> Средний пароль (оценка 3 из 5)
Abcdef123! -> Сильный пароль (оценка 5 из 5)
```

## Особенности

- **Воспроизводимость:** одинаковый `seed` всегда даёт одинаковый пароль
- **Псевдослучайность:** используется линейный конгруэнтный генератор (LCG)
- **Один балл за признак:** несколько цифр дают только один балл за "наличие цифры"
