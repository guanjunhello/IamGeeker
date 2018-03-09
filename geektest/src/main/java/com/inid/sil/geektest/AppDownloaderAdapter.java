package com.inid.sil.geektest;

import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.util.List;

/**
 * created by Guan at 2018/3/8 0008 下午 3:22
 * description:
 */
public class AppDownloaderAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> implements View.OnClickListener {


    private NotifyUtil currentNotify;

    public AppDownloaderAdapter(@Nullable List<AppInfo> data) {
        super(R.layout.adapter_app_downloader, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfo item) {
        ImageView iv_icon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(item.getIcon()).into(iv_icon);

        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_size, item.getSize());
        helper.setText(R.id.tv_description, item.getDescription());

        Button btn_download = helper.getView(R.id.btn_download);
        btn_download.setTag(helper);
        btn_download.setOnClickListener(this);



    }

    @Override
    public void onClick(final View view) {
        final BaseViewHolder helper = (BaseViewHolder) view.getTag();
        final ProgressBar progressbar = helper.getView(R.id.progressbar);
        final TextView tv_progress = helper.getView(R.id.tv_progress);
        final LinearLayout ll_description = helper.getView(R.id.ll_description);
        if(progressbar.getVisibility()==View.VISIBLE){
            if(((Button)view).getText().toString().equals("下载中")){
                ((Button)view).setText("暂停");
                ((BaseDownloadTask)progressbar.getTag()).pause();
            }else {
                ((Button)view).setText("下载中");
                BaseDownloadTask downloadTask = FileDownloader.getImpl().create(mData.get(helper.getLayoutPosition()).getUrl())
                        .setPath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + mData.get(helper.getLayoutPosition()).getName() + ".apk")
                        .setListener(new FileDownloadListener() {
                            @Override
                            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                            }

                            @Override
                            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                progressbar.setProgress(100 * (soFarBytes/1000) / (totalBytes/1000));
                                tv_progress.setText((100 * (soFarBytes/1000) / (totalBytes/1000)) + "%");
                                notify_progress(mData.get(helper.getLayoutPosition()).getName(), 100 * (soFarBytes/1000) / (totalBytes/1000));
                            }

                            @Override
                            protected void completed(BaseDownloadTask task) {
                                progressbar.setVisibility(View.GONE);
                                tv_progress.setVisibility(View.GONE);
                                progressbar.setProgress(0);
                                tv_progress.setText("0%");
                                ll_description.setVisibility(View.VISIBLE);
                                ToastUtils.showShort("下载完成");
                                ((Button)view).setText("下载");
                                currentNotify.clear();
                            }

                            @Override
                            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                            }

                            @Override
                            protected void error(BaseDownloadTask task, Throwable e) {

                            }

                            @Override
                            protected void warn(BaseDownloadTask task) {

                            }
                        });
                downloadTask.start();
                progressbar.setTag(downloadTask);
            }
        }else {
            ((Button)view).setText("下载中");
            progressbar.setVisibility(View.VISIBLE);
            tv_progress.setVisibility(View.VISIBLE);
            ll_description.setVisibility(View.INVISIBLE);
            FileDownloader.setup(mContext);
            BaseDownloadTask downloadTask = FileDownloader.getImpl().create(mData.get(helper.getLayoutPosition()).getUrl())
                    .setPath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + mData.get(helper.getLayoutPosition()).getName() + ".apk")
                    .setListener(new FileDownloadListener() {
                        @Override
                        protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                        }

                        @Override
                        protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                            progressbar.setProgress(100 * (soFarBytes/1000) / (totalBytes/1000));
                            tv_progress.setText((100 * (soFarBytes/1000) / (totalBytes/1000)) + "%");
                            notify_progress(mData.get(helper.getLayoutPosition()).getName(), 100 * (soFarBytes/1000) / (totalBytes/1000));
                        }

                        @Override
                        protected void completed(BaseDownloadTask task) {
                            progressbar.setVisibility(View.GONE);
                            tv_progress.setVisibility(View.GONE);
                            progressbar.setProgress(0);
                            tv_progress.setText("0%");
                            ll_description.setVisibility(View.VISIBLE);
                            ToastUtils.showShort("下载完成");
                            ((Button)view).setText("下载");
                            currentNotify.clear();
                        }

                        @Override
                        protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                        }

                        @Override
                        protected void error(BaseDownloadTask task, Throwable e) {

                        }

                        @Override
                        protected void warn(BaseDownloadTask task) {

                        }
                    });
            downloadTask.start();
            progressbar.setTag(downloadTask);
        }
    }

    /**
     * 高仿Android系统下载样式
     */
    private void notify_progress(String name, int progress) {
        int smallIcon = R.mipmap.ic_launcher;
        String ticker = "您有一条新通知";
        //实例化工具类，并且调用接口
        NotifyUtil notify7 = new NotifyUtil(mContext, 7);
        notify7.notify_progress(null, smallIcon, ticker, name+"下载", "正在下载中", progress, true, false, false);
        currentNotify = notify7;
    }


}
