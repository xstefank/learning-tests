package org.learn.axonframework.axonlt.account;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;
import org.learn.axonframework.axonlt.coreapi.AccountCreatedEvent;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.MoneyWithdrawnEvent;
import org.learn.axonframework.axonlt.coreapi.WithdrawMoneyCommand;


public class AccountTest {

    private static final String ACCOUNT_ID = "1234";

    private FixtureConfiguration<Account> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Account.class);
    }

    @Test
    public void testCreateAccount() throws Exception {
        fixture.givenNoPriorActivity()
                .when(new CreateAccountCommand(ACCOUNT_ID, 1000))
                .expectEvents(new AccountCreatedEvent(ACCOUNT_ID, 1000));
    }

    @Test
    public void testWithdrawReasonableAmount() {
        fixture.given(new AccountCreatedEvent(ACCOUNT_ID, 1000))
                .when(new WithdrawMoneyCommand(ACCOUNT_ID, 600))
                .expectEvents(new MoneyWithdrawnEvent(ACCOUNT_ID, 600, -600));
    }

    @Test
    public void testWithdrawAbsurdAmount() {
        fixture.given(new AccountCreatedEvent(ACCOUNT_ID, 1000))
                .when(new WithdrawMoneyCommand(ACCOUNT_ID, 1001))
                .expectNoEvents()
                .expectException(OverdraftLimitExceededException.class);
    }

    @Test
    public void testWithdrawTwice() {
        fixture.given(new AccountCreatedEvent(ACCOUNT_ID, 1000),
                new MoneyWithdrawnEvent(ACCOUNT_ID, 999, -999))
                .when(new WithdrawMoneyCommand(ACCOUNT_ID, 2))
                .expectException(OverdraftLimitExceededException.class);
    }

}