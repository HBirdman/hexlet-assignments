@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

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
    <h1>LogIn</h1>
    @if(page != null)
        <div>
            <h1>${page.getError()}</h1>
        </div>
    @endif
    <div>
        <form action="${NamedRoutes.loginPath()}" method="post">
            <input type="text" placeholder="Name" name="name" />
            <input type="password" placeholder="Password" name="password" />
            <input type="submit" />
        </form>
    </div>
</main>
</body>
</html>
`
)