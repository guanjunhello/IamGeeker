package com.inid.sil.studynotes;

import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.ToastUtils;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.styles.Github;

public class DetailActivity extends BaseActivity {

    private MarkdownView mMarkdownView;
    private NoteInfo noteInfo;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initViews() {
        noteInfo = getIntent().getParcelableExtra("note");
        if(noteInfo==null){
            ToastUtils.showShort("暂无数据");
            finish();
            return;
        }
        setTitle(noteInfo.getTitle());
        mMarkdownView = findViewById(R.id.markdown_view);
        mMarkdownView.addStyleSheet(new Github());
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(mMarkdownView!=null&&noteInfo!=null){
            mMarkdownView.loadMarkdownFromAsset(noteInfo.getSource());
        }
    }

    public static void open(Context context, NoteInfo noteInfo){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("note", noteInfo);
        context.startActivity(intent);
    }
}
