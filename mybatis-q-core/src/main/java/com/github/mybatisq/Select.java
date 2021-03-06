package com.github.mybatisq;

/**
 * 子查询
 * @param <T> 表类型
 * @param <D> 数据类型
 */
public class Select<T extends Table, D> {

    /**
     * 新建子查询
     * @param table 表
     * @param column 列
     */
    public Select(T table, Column<T, D> column) {
        this.tableName = table.getName();
        this.tableAlias = table.getAlias();
        this.columnName = column.getName();
    }

    /**
     * where条件
     * @param where where条件
     * @return 子查询
     */
    public Select<T, D> where(Where where) {
        this.where = where;
        return this;
    }

    /**
     * 排序
     * @param orderBy 排序
     * @return 子查询
     */
    public Select<T, D> orderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    /**
     * 限制子查询返回的数据行（limit ..., ?）
     * @param limit 限制的数据行数
     * @return 子查询
     */
    public Select<T, D> limit(int limit) {
        this.limit = limit;
        if (this.skip == null) {
            this.skip = 0;
        }
        return this;
    }

    /**
     * 跳过子查询返回的行数（limit ?, ...）
     * @param skip 跳过的数据行数
     * @return 子查询
     */
    public Select<T, D> skip(int skip) {
        this.skip = skip;
        if (this.limit == null) {
            this.limit = Integer.MAX_VALUE;
        }
        return this;
    }

    /**
     * 表名称
     */
    private final String tableName;

    /**
     * 表别名
     */
    private final String tableAlias;

    /**
     * where条件
     */
    private Where where;

    /**
     * 排序
     */
    private OrderBy orderBy;

    /**
     * 限制的数据行数
     */
    private Integer limit;

    /**
     * 跳过的数据行数
     */
    private Integer skip;

    /**
     * 列名
     */
    private final String columnName;

    /**
     * 获取表名称
     * @return 表名称
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 获取表别名
     * @return 表别名
     */
    public String getTableAlias() {
        return tableAlias;
    }

    /**
     * 获取where条件
     * @return where条件
     */
    public Where getWhere() {
        return where;
    }

    /**
     * 获取排序
     * @return 排序
     */
    public OrderBy getOrderBy() {
        return orderBy;
    }

    /**
     * 获取列名
     * @return 列名
     */
    public String getColumnName() {
        return columnName;
    }
}
