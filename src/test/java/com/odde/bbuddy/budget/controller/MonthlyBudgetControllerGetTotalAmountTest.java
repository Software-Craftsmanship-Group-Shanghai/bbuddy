package com.odde.bbuddy.budget.controller;

import com.odde.bbuddy.budget.domain.MonthlyBudgetPlanner;
import com.odde.bbuddy.budget.view.MonthlyBudgetAmount;
import org.junit.Test;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.util.Date;

import static com.odde.bbuddy.common.controller.Urls.MONTHLYBUDGET_TOTALAMOUNT;
import static com.odde.bbuddy.common.Formats.parseDay;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MonthlyBudgetControllerGetTotalAmountTest {

    MonthlyBudgetPlanner mockPlanner = mock(MonthlyBudgetPlanner.class);
    MonthlyBudgetAmount mockMonthlyBudgetAmount = mock(MonthlyBudgetAmount.class);
    MonthlyBudgetController controller = new MonthlyBudgetController(mockPlanner, mockMonthlyBudgetAmount);

    Date startDate = parseDay("2016-07-01");
    Date endDate = parseDay("2016-07-10");
    Model stubModel = mock(Model.class);

    @Test
    public void go_to_get_amount_page() throws ParseException {
        assertThat(getAmount()).isEqualTo(MONTHLYBUDGET_TOTALAMOUNT);
    }

    @Test
    public void get_amount_from_monthly_budget_planner() throws ParseException {
        getAmount();

        verify(mockPlanner).getAmount(startDate, endDate);
    }

    @Test
    public void pass_amount_to_page() {
        when(mockPlanner.getAmount(startDate, endDate)).thenReturn(100L);

        getAmount();

        verify(mockMonthlyBudgetAmount).display(stubModel, 100L);
    }

    private String getAmount() {
        return controller.totalAmountOfMonthlyBudget(startDate, endDate, stubModel);
    }

}