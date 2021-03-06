package com.github.mybatisq.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class EmpDeptTable extends Table {

    private EmpDeptTable() {
        super("emp_dept", "e");
    }

    public static final EmpDeptTable emp_dept = new EmpDeptTable();

    public Query<EmpDeptTable> query() {
        return new Query<>(emp_dept);
    }

    public <T extends Table> Join<EmpDeptTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * id
     */
    public Column<EmpDeptTable, Integer> ed_id = new Column<>("ed_id");

    /**
     * 员工id
     */
    public Column<EmpDeptTable, Integer> emp_id = new Column<>("emp_id");

    /**
     * 部门id
     */
    public Column<EmpDeptTable, Integer> dept_id = new Column<>("dept_id");
}