@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`

<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<main>
    <h1>Привет, Хекслет!</h1>
    @if(page.getName() != null)
        Добро пожаловать, ${page.getName().toString()}.
        Чтобы разлогиниться, удалите куку JSESSIONID из браузера
        <form>
            <input type="button" placeholder="Выйти"/>
        </form>
    @else
        <h1 href="${NamedRoutes.loginPath()}">Войти</h1>
    @endif
</main>
</body>
</html>
`
)