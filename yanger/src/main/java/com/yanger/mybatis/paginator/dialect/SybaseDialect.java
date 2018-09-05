package com.yanger.mybatis.paginator.dialect;

import org.apache.ibatis.mapping.MappedStatement;

import com.yanger.mybatis.core.PageParam;

public class SybaseDialect extends Dialect{

    public SybaseDialect(MappedStatement mappedStatement, Object parameterObject, PageParam pageParam) {
        super(mappedStatement, parameterObject, pageParam);
    }

    @Override
    protected String getLimitString(String sql, String offsetName,int offset, String limitName, int limit) {
		throw new UnsupportedOperationException( "paged queries not supported" );
	}

}
