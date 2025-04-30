package server.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_groups")
public class ExpenseGroup extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "expense_group_name", nullable = false)
    private String expenseGroupName;

    @Column(name = "colour", nullable = false)
    private String colour;

    protected ExpenseGroup() { }

    public ExpenseGroup(User user, String expenseGroupName, String colour) {
        this.user = user;
        this.expenseGroupName = expenseGroupName;
        this.colour = colour;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExpenseGroupName() {
        return this.expenseGroupName;
    }

    public void setExpenseGroupName(String expenseGroupName) {
        this.expenseGroupName = expenseGroupName;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
