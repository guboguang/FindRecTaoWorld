package com.flame.icebound.taoworld.modules.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flame.icebound.taoworld.R;
import com.flame.icebound.taoworld.modules.home.bean.ImageTagInfo;
import com.flame.icebound.taoworld.modules.home.bean.ShareTopic;
import com.flame.icebound.taoworld.modules.home.i.HomeProtocol;
import com.flame.icebound.taoworld.modules.home.util.SpanClickableText;
import com.flame.icebound.taoworld.modules.home.util.TostUtils;
import com.flame.icebound.taoworld.modules.home.util.Utility;
import com.flame.icebound.taoworld.modules.home.widget.ExpandableTextView;
import com.flame.icebound.taoworld.modules.home.widget.ImageTagView;
import com.flame.icebound.taoworld.util.ImageLoaderUtil;
import com.flame.icebound.taoworld.widget.FlowLayout;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Administrator on 2016/7/30.
 */
public class ShareTopicAdapter extends BaseAdapter implements StickyListHeadersAdapter {


    private Context mContext;
    private List<ShareTopic.RstBean.ShareListBean> mList;
//    private final Animation animation;
    //    private Ani

    public enum LookingStatus {Open, Close}

    public ShareTopicAdapter(Context mContext, List<ShareTopic.RstBean.ShareListBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
//        animation = AnimationUtils.loadAnimation(mContext, R.anim.home_item_anim_layout);
    }


    //头部适配器
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = View.inflate(mContext, R.layout.item_home_header, null);
            holder.user_head = (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.user_name = (TextView) convertView.findViewById(R.id.tv_user_name);
            holder.tips = (TextView) convertView.findViewById(R.id.tv_tips);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        //加载时的显示动画
//        convertView.startAnimation(animation);
        ShareTopic.RstBean.ShareListBean shareInfo = mList.get(position);

        holder.user_name.setText(shareInfo.getUser_name());
        holder.tips.setText(shareInfo.getTips());
        //头像
        setImageByUrl(holder.user_head, HomeProtocol.IMGURL + shareInfo.getUser_head());

        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return position;
    }

    class HeaderViewHolder {
        //用户头像
        ImageView user_head;
        //用户名
        TextView user_name;
        TextView tips;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            view = View.inflate(mContext, R.layout.item_home_content, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        ShareTopic.RstBean.ShareListBean shareInfo = mList.get(position);

     /*   //设置Item的数据
        viewHolder.user_name.setText(shareInfo.getUser_name());

        viewHolder.tips.setText(shareInfo.getTips());
        //头像
        setImageByUrl(viewHolder.user_head, HomeProtocol.IMGURL + shareInfo.getUser_head());*/

        //话题图片
        setViewPagerByImage(shareInfo, viewHolder.imgs, viewHolder.imageIndicator);
        //设置话题详情
        // setReviewDetail(shareInfo,viewHolder);
        viewHolder.review_detail.setText(shareInfo.getReview_detail(),new SparseBooleanArray(mList.size()),position);
        //设置标签Taglist
        setTagList(shareInfo, viewHolder.tagList);
        //设置话题评论
        setComment(shareInfo, viewHolder.commentCount, viewHolder.commentList);
        //设置分享商品
        setShareStock(shareInfo, viewHolder.shareStockList);
        return view;
    }

    /**
     * 设置分享的列表
     *
     * @param shareInfo
     * @param shareStockList
     */
    private void setShareStock(final ShareTopic.RstBean.ShareListBean shareInfo, final ListView shareStockList) {
        Log.e(HomeProtocol.TAG, "设置分享列表");
        List<ShareTopic.RstBean.ShareListBean.ShareStockListBean> stocks = shareInfo.getShareStockList();
        if (stocks.size() == 0) {
            //不存在商品，隐藏列表
            shareStockList.setVisibility(View.GONE);
            return;
        }
        Log.e(HomeProtocol.TAG, "stocks.size()==" + stocks.size());
        shareStockList.setVisibility(View.VISIBLE);
        //清空listView的所以Item
        //清除原来的脚页视图
        if (shareStockList.getTag() != null) {
            shareStockList.removeFooterView((View) shareStockList.getTag());
            shareStockList.setTag(null);
        }

        final List<ShareTopic.RstBean.ShareListBean.ShareStockListBean> mStocks = shareInfo.getShareStockList();
        final ShareStockAdapter mStockAdapter = new ShareStockAdapter(mContext, mStocks);

        if (mStocks.size() > HomeProtocol.STOCK_DEF_COUNT) {

            //添加脚部
            final View footView = View.inflate(mContext, R.layout.item_home_stock_foot, null);
            final TextView footText = (TextView) footView.findViewById(R.id.tv_look_other);
            footView.setTag(LookingStatus.Close);
            //设置脚部监听
            footText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    TostUtils.ShowTost(mContext,"点击了，footView");
                    LookingStatus status = (LookingStatus) footView.getTag();
                    if (status == LookingStatus.Close) {
                        footText.setText("收起");
                        footView.setTag(LookingStatus.Open);
                        TostUtils.ShowTost(mContext, "查看其它");
                        TostUtils.ShowTost(mContext, "数目" + mStocks.size());
                        mStockAdapter.addItemNum(mStocks.size());
                    } else {
                        mStockAdapter.addItemNum(HomeProtocol.STOCK_DEF_COUNT);
                        footText.setText("查看其它商品");
                        TostUtils.ShowTost(mContext, "收起");
                        footView.setTag(LookingStatus.Close);
                    }
                    Utility.setListViewHeightBasedOnChildren(shareStockList);
                    mStockAdapter.notifyDataSetChanged();
                }
            });
            shareStockList.addFooterView(footView);
            shareStockList.setTag(footView);
        }
        //设置适配器
        shareStockList.setAdapter(mStockAdapter);
        //根据item的条目设置listview的高度
        Utility.setListViewHeightBasedOnChildren(shareStockList);
    }

    /**
     * 设置话题评论表
     *
     * @param shareInfo
     * @param commentCount
     * @param commentList
     */
    private void setComment(ShareTopic.RstBean.ShareListBean shareInfo, TextView commentCount,
                            LinearLayout commentList) {
        //清空所有子控件
        commentList.removeAllViews();
        //默认隐藏，查看所有评论按钮
        commentCount.setVisibility(View.GONE);
        Log.d(HomeProtocol.TAG, "commentCount=" + shareInfo.getCommentCount());
        //获取需要显示的评论列表
        List<ShareTopic.RstBean.ShareListBean.CommentBean> mCommentList = shareInfo.getComment();
        for (final ShareTopic.RstBean.ShareListBean.CommentBean comment : mCommentList) {
            //获取可点击的部分文字
            SpanClickableText span = getSpanClickableText(comment);
            //将文字填充如TextView
            TextView textView = getSpanClickableTextView();
            textView.setText(span);
            commentList.addView(textView);
        }
        //判断是否显示查看所有按钮
        if (Integer.parseInt(shareInfo.getCommentCount()) < 6) {
            return;
        }
        commentCount.setVisibility(View.VISIBLE);
        commentCount.setText("查看所有" + shareInfo.getCommentCount() + "条评论");
        commentCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TostUtils.ShowTost(mContext, "查看所有条评论");
            }
        });

    }


    @NonNull
    private TextView getSpanClickableTextView() {
        TextView textView = new TextView(mContext);
        textView.setPadding(2, 6, 2, 6);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        //设置点击背景色为透明
        textView.setHighlightColor(Color.TRANSPARENT);
        //配置布局参数
          /*  ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);*/
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        Log.d(HomeProtocol.TAG, "内容==" + textView.getText().toString());
        textView.setLayoutParams(params);
        return textView;
    }

    @NonNull
    private SpanClickableText getSpanClickableText(final ShareTopic.RstBean.ShareListBean.CommentBean comment) {
        String authorName = comment.getAuthorName();
        String cm = null;
        //判断是否是回复评论
        if (TextUtils.isEmpty(authorName)) {
            cm = comment.getUserName() + ":  " + comment.getAuthorName() + comment.getMessage();
        } else {
            cm = comment.getUserName() + "  回复  " + comment.getAuthorName() + ":  " + comment.getMessage();
        }

        //设置部分文字可点击
        SpanClickableText span = new SpanClickableText(cm);
        //UserName的点击事件
        span.setSpanForClick(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                TostUtils.ShowTost(mContext, comment.getUserName());
            }
        }, 0, comment.getUserName().length(), Color.GRAY, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //Message的点击事件
        span.setSpanForClick(new ClickableSpan() {
                                 @Override
                                 public void onClick(View widget) {
                                     TostUtils.ShowTost(mContext, comment.getMessage());
                                 }
                             }, cm.indexOf(comment.getMessage()), cm.indexOf(comment.getMessage()) + comment.getMessage().length(),
                Color.parseColor("#aa000000"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //authorName的点击事件
        if (!TextUtils.isEmpty(authorName)) {
            span.setSpanForClick(new ClickableSpan() {
                                     @Override
                                     public void onClick(View widget) {
                                         TostUtils.ShowTost(mContext, comment.getAuthorName());
                                     }
                                 }, cm.indexOf(comment.getAuthorName()), cm.indexOf(comment.getAuthorName()) + comment.getAuthorName().length(), Color.GRAY,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return span;
    }

    /**
     * 设置标签列表
     *
     * @param shareInfo
     * @param tagList
     */
    private void setTagList(ShareTopic.RstBean.ShareListBean shareInfo, FlowLayout tagList) {
//        tagList.clearDisappearingChildren();
        tagList.removeAllViews();
        //获取数据列表
        List<ShareTopic.RstBean.ShareListBean.TagListBean> mTags = shareInfo.getTagList();
        Log.d(HomeProtocol.TAG, "mTags=" + mTags.size() + "");
        //创建布局参数对象
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 10;
        lp.rightMargin = 10;
        lp.topMargin = 10;
        lp.bottomMargin = 10;

        for (ShareTopic.RstBean.ShareListBean.TagListBean tag : mTags) {
            TextView view = new TextView(mContext);
            view.setPadding(10, 8, 10, 8);
            view.setText(tag.getTag_name());
            Log.d(HomeProtocol.TAG, tag.getTag_name());
            view.setTextSize(12);
            view.setTextColor(Color.parseColor("#aaff0000"));
            view.setBackgroundColor(Color.parseColor("#11ff0000"));
            tagList.addView(view, lp);
        }

    }

    /**
     * 设置ViewPager的图片
     *
     * @param shareInfo
     * @param imgs
     * @param imageIndicator
     */
    private void setViewPagerByImage(ShareTopic.RstBean.ShareListBean shareInfo, ViewPager imgs, final LinearLayout imageIndicator) {

        imgs.setVisibility(View.VISIBLE);
        imageIndicator.removeAllViews();
        List<ShareTopic.RstBean.ShareListBean.ImgListBean> mImages = shareInfo.getImg_list();
        //或没有图片展示则隐藏
        if (mImages.size() <= 0) {
            imgs.setVisibility(View.GONE);
            return;
        }
        final List<RelativeLayout> mImageList = new ArrayList<>();
        int i = 0;
        for (ShareTopic.RstBean.ShareListBean.ImgListBean image : mImages) {

            RelativeLayout iamgeGroup = (RelativeLayout) View.inflate(mContext, R.layout.item_home_images, null);
            ImageView imageView = (ImageView) iamgeGroup.findViewById(R.id.iv_pic);

            //显示图片
            ImageLoader.getInstance().displayImage(HomeProtocol.IMGURL + image.getImg(), imageView);
            //设置Tag
            setIamgeTage(image, iamgeGroup);

            mImageList.add(iamgeGroup);

            if (mImages.size() > 1) {
                //设置指示标识
                ImageView indicator = new ImageView(mContext);
                //设置布局参数
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                param.rightMargin = 5;
                param.leftMargin = 5;
                indicator.setLayoutParams(param);
                indicator.setImageResource(R.drawable.selector_home_inditator);
                //默认显示第一张图片
                if (i == 0) {
                    indicator.setEnabled(true);
                } else {
                    indicator.setEnabled(false);
                }
                imageIndicator.addView(indicator);
            }
            i++;
        }

        /**
         * 设置ViewPager的页面滑动监听
         */

        imgs.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int lastIndicatorPosition;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                position=position%mImageList.size();
                //将图片的指示卡点亮
                imageIndicator.getChildAt(position).setEnabled(true);
                //上一个变暗
                imageIndicator.getChildAt(lastIndicatorPosition).setEnabled(false);
                lastIndicatorPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        PagerAdapter adapter = new ImagePagerAdapter(mImageList);
        imgs.setAdapter(adapter);
    }

    /**
     * 设置图片的Tag
     *
     * @param imageTag
     * @param iamgeGroup
     */
    private void setIamgeTage(ShareTopic.RstBean.ShareListBean.ImgListBean imageTag, RelativeLayout iamgeGroup) {
        final List<ShareTopic.RstBean.ShareListBean.ImgListBean.TagBean> tagList = imageTag.getTag();
        if (tagList.size() == 0) {
            return;
        }
        int i = 0;
        for (ShareTopic.RstBean.ShareListBean.ImgListBean.TagBean tag : tagList) {
            ShareTopic.RstBean.ShareListBean.ImgListBean.TagBean.TagInfoBean tagInfo = tag.getTagInfo();
            //获取显示信息
            final String name = tagInfo.getBrand().getName() + "  " + tagInfo.getCategory().getName();
            String price = tagInfo.getPrice();
            final String location = tagInfo.getLocation().getName();

            ShareTopic.RstBean.ShareListBean.ImgListBean.TagBean.PositionBean position = tag.getPosition();
            ImageTagInfo imageTagInfo = new ImageTagInfo(name, price, location,
                    new ImageTagInfo.Position(position.getX(), position.getY()));

            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.MATCH_PARENT);

            ImageTagView view = (ImageTagView) View.inflate(mContext, R.layout.item_home_image_tag, null);

            /**
             * 给imagetag设置点击事件
             */
            if (!TextUtils.isEmpty(location)) {
                view.findViewById(R.id.tv_position).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TostUtils.ShowTost(mContext, location);
                    }
                });
            }

            view.findViewById(R.id.tv_brand).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TostUtils.ShowTost(mContext, name);
                }
            });

            view.setLayoutParams(params);

            view.setImageTag(imageTagInfo, null);
            iamgeGroup.addView(view, i + 1);
            i++;
        }
    }


    /**
     * 为Images设置头像图片
     *
     * @return
     */
    public void setImageByUrl(ImageView imageView, String url) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                // 设置图片质量
                .bitmapConfig(Bitmap.Config.RGB_565)
                // 设置内存缓存
                .cacheInMemory(true)
                // 设置磁盘缓存
                .cacheOnDisk(true)
                // 设置图片特效
                .displayer(new FadeInBitmapDisplayer(300)).build();
        ImageLoader.getInstance().displayImage(url, imageView,
                ImageLoaderUtil.getCircleOption(Color.WHITE, 1.0f));
    }

  /*  private int id;
    private int user_id;
    private String review_detail;
    private int create_time;
    private String redact_comment;
    private Tag_infoBean tag_info;
    private String follow;
    private int is_office;
    private String ;
    private int is_follow;
    private String user_head;
    private String commentCount;
    private String position;
    private String ;
      private List<CommentBean> comment;
            private List<TagListBean> tagList;
            private List<ShareStockListBean> shareStockList;
            private List<ImgListBean> img_list;
    private List<String> imgs;*/

    class ViewHolder {

        private View view;
        /*  //用户头像
          ImageView user_head;
          //用户名
          TextView user_name;
          TextView tips;*/
        //话题详情
        ExpandableTextView review_detail;

        //ViewPager图片片
        ViewPager imgs;
        //热词
        FlowLayout tagList;
        //评论
        LinearLayout commentList;
        TextView commentCount;
        //商品列表
        ListView shareStockList;
        private final LinearLayout imageIndicator;

        public ViewHolder(View view) {
            this.view = view;

            review_detail = (ExpandableTextView) view.findViewById(R.id.expand_text_view);

            //图片
            imgs = (ViewPager) view.findViewById(R.id.vp_image);
            imageIndicator = (LinearLayout) view.findViewById(R.id.ll_indicator);
            tagList = (FlowLayout) view.findViewById(R.id.fl_label);
            //评论
            commentList = (LinearLayout) view.findViewById(R.id.ll_home_comment);
            commentCount = (TextView) view.findViewById(R.id.tv_comments);
            //商品
            shareStockList = (ListView) view.findViewById(R.id.lv_home_stock);

        }


    }

}
