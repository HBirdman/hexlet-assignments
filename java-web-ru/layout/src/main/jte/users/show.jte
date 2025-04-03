@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
    <p>Имя: ${page.getUser().getFirstName()}, фамилия: ${page.getUser().getLastName()}</p>
`,
    header = @`
    <h1 href="/">Link to main page</h1>
    <h2 href="/users">Посмотреть список пользователей</h2>
`,
    footer = @`
    <h1>This is the end.</h1>
`
)