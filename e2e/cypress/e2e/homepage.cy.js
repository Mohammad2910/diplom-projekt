describe('Access without authentication', () => {
    it('Redirect to login page', () => {
        cy.visit('https://projekt-mohammad.ddns.net/home');
        cy.contains('Sign in to your account');
        cy.get("#username");
        cy.get("#password");
        cy.get("#kc-login");
    })
})
