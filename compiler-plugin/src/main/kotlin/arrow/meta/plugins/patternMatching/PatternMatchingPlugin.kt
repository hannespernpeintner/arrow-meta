package arrow.meta.plugins.patternMatching

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.callExpression

val Meta.patternMatching: CliPlugin
  get() = "pattern matching" {
    meta(
      callExpression({ this follows casePatternRules }) { expr ->
        Transform.replace(expr, expr.desugared.callExpression)
      }
    )
  }