package server.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity()
@Table(name = "Expenses")
public class Expense extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expenseGroupId")
    private ExpenseGroup expenseGroup;

    @Column(nullable = false)
    private String expenseName;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, insertable = false, updatable = false)
    private LocalDateTime dateCreated;

    protected Expense() { }

    public Expense(User user, ExpenseGroup expenseGroup, String expenseName, BigDecimal amount) {
        this.user = user;
        this.expenseGroup = expenseGroup;
        this.expenseName = expenseName;
        this.amount = amount;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExpenseGroup getExpenseGroup() {
        return this.expenseGroup;
    }

    public void setExpenseGroup(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }

    public String getExpenseName() {
        return this.expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }
}
