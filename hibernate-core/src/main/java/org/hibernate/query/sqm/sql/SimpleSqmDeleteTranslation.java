/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.query.sqm.sql;

import java.util.List;
import java.util.Map;

import org.hibernate.query.sqm.tree.expression.SqmParameter;
import org.hibernate.sql.ast.spi.FromClauseAccess;
import org.hibernate.sql.ast.spi.SqlExpressionResolver;
import org.hibernate.sql.ast.tree.delete.DeleteStatement;
import org.hibernate.sql.exec.spi.JdbcParameter;

/**
 * @author Steve Ebersole
 */
public class SimpleSqmDeleteTranslation implements SqmTranslation {
	private final DeleteStatement sqlAst;
	private final Map<SqmParameter, List<JdbcParameter>> jdbcParamMap;
	private final SqlExpressionResolver sqlExpressionResolver;
	private final FromClauseAccess fromClauseAccess;

	public SimpleSqmDeleteTranslation(
			DeleteStatement sqlAst,
			Map<SqmParameter, List<JdbcParameter>> jdbcParamMap,
			SqlExpressionResolver sqlExpressionResolver,
			FromClauseAccess fromClauseAccess) {
		this.sqlAst = sqlAst;
		this.jdbcParamMap = jdbcParamMap;
		this.sqlExpressionResolver = sqlExpressionResolver;
		this.fromClauseAccess = fromClauseAccess;
	}

	@Override
	public DeleteStatement getSqlAst() {
		return sqlAst;
	}

	@Override
	public Map<SqmParameter, List<JdbcParameter>> getJdbcParamsBySqmParam() {
		return jdbcParamMap;
	}

	public SqlExpressionResolver getSqlExpressionResolver() {
		return sqlExpressionResolver;
	}

	public FromClauseAccess getFromClauseAccess() {
		return fromClauseAccess;
	}
}
