@import exercise.Data
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Список всех пользователей:</h1>
    @for(var user : Data.getUsers())
            <div>${user.getFirstName()}, ${user.getLastName()}</div>
    @endfor
`,
header = @`
    <h1 href="/">Link to main page</h1>
    <h2 href="/users">Посмотреть список пользователей</h2>
    <h2>Welcome, user!</h2>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)