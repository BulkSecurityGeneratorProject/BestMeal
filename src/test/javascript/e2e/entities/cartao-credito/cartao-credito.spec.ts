/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { CartaoCreditoComponentsPage, CartaoCreditoDeleteDialog, CartaoCreditoUpdatePage } from './cartao-credito.page-object';

const expect = chai.expect;

describe('CartaoCredito e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let cartaoCreditoUpdatePage: CartaoCreditoUpdatePage;
  let cartaoCreditoComponentsPage: CartaoCreditoComponentsPage;
  let cartaoCreditoDeleteDialog: CartaoCreditoDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load CartaoCreditos', async () => {
    await navBarPage.goToEntity('cartao-credito');
    cartaoCreditoComponentsPage = new CartaoCreditoComponentsPage();
    await browser.wait(ec.visibilityOf(cartaoCreditoComponentsPage.title), 5000);
    expect(await cartaoCreditoComponentsPage.getTitle()).to.eq('bestmealApp.cartaoCredito.home.title');
  });

  it('should load create CartaoCredito page', async () => {
    await cartaoCreditoComponentsPage.clickOnCreateButton();
    cartaoCreditoUpdatePage = new CartaoCreditoUpdatePage();
    expect(await cartaoCreditoUpdatePage.getPageTitle()).to.eq('bestmealApp.cartaoCredito.home.createOrEditLabel');
    await cartaoCreditoUpdatePage.cancel();
  });

  it('should create and save CartaoCreditos', async () => {
    const nbButtonsBeforeCreate = await cartaoCreditoComponentsPage.countDeleteButtons();

    await cartaoCreditoComponentsPage.clickOnCreateButton();
    await promise.all([
      cartaoCreditoUpdatePage.setNomeCartaoInput('nomeCartao'),
      cartaoCreditoUpdatePage.bandeiraSelectLastOption(),
      cartaoCreditoUpdatePage.setNumeroInput('numero'),
      cartaoCreditoUpdatePage.setCvvInput('cvv'),
      cartaoCreditoUpdatePage.setValidadeInput('validade')
    ]);
    expect(await cartaoCreditoUpdatePage.getNomeCartaoInput()).to.eq('nomeCartao', 'Expected NomeCartao value to be equals to nomeCartao');
    expect(await cartaoCreditoUpdatePage.getNumeroInput()).to.eq('numero', 'Expected Numero value to be equals to numero');
    expect(await cartaoCreditoUpdatePage.getCvvInput()).to.eq('cvv', 'Expected Cvv value to be equals to cvv');
    expect(await cartaoCreditoUpdatePage.getValidadeInput()).to.eq('validade', 'Expected Validade value to be equals to validade');
    await cartaoCreditoUpdatePage.save();
    expect(await cartaoCreditoUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await cartaoCreditoComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last CartaoCredito', async () => {
    const nbButtonsBeforeDelete = await cartaoCreditoComponentsPage.countDeleteButtons();
    await cartaoCreditoComponentsPage.clickOnLastDeleteButton();

    cartaoCreditoDeleteDialog = new CartaoCreditoDeleteDialog();
    expect(await cartaoCreditoDeleteDialog.getDialogTitle()).to.eq('bestmealApp.cartaoCredito.delete.question');
    await cartaoCreditoDeleteDialog.clickOnConfirmButton();

    expect(await cartaoCreditoComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
