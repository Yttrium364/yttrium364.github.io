package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.layout

import androidx.compose.foundation.lazy.LazyListState
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.SectionId
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface SectionNavigator {
    fun go(id: SectionId)
}

class SectionScroller(
    private val listState: LazyListState,
    private val indexOf: (SectionId) -> Int,
    private val scope: CoroutineScope,
) : SectionNavigator {
    override fun go(id: SectionId) {
        scope.launch { listState.animateScrollToItem(indexOf(id)) }
    }
}

object SectionOrder {
    private val sections = listOf(
        SectionId.Hero,
        SectionId.Why,
        SectionId.Kmp,
        SectionId.Projects,
        SectionId.Live,
    )

    fun indexOf(id: SectionId): Int = sections.indexOf(id)
}
