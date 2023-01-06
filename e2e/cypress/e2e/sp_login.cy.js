describe('Login page test', () => {
  it('Login with username and password', () => {
    cy.visit('https://projekt-mohammad.ddns.net');
    cy.contains('Sign in');
    cy.get("#username").type("user");
    cy.get("#password").type("user");
    cy.get("#kc-login").click();
  })
})
