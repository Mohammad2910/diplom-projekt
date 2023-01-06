describe('Login page test', () => {
    it('Login with adfs', () => {
        cy.visit('https://projekt-mohammad.ddns.net');
        cy.contains('ADFS').click();
        cy.get("#userNameInput").type('test_user@adfs-windows.ddns.net');
        cy.get("#passwordInput").type('projekt1234!');
        cy.get('#submitButton').click();
        // cy.get("#password").type("user");
        // cy.get("#kc-login").click();
    })
})
