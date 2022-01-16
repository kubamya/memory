<template>
  <div class="content-container">
    <!-- 主题 -->
    <ThemeList></ThemeList>

    <!-- 文章列表 -->
    <div class="content-passage-container">
      <div class="passage" v-for="passage in passages" :key="passage.id">
        <div class="passage-cover">
          <img :src="passage.cover">
        </div>
        <div class="passage-author-avatar">
          <img :src="passage.avatar">
        </div>
        <div class="passage-title">{{passage.title}}</div>
        <div class="passage-public-info">{{passage.author}} · {{passage.publicTime}}</div>
        <div class="passage-info">
          <span>浏览：{{passage.views}}</span>
          <span>评论：{{passage.comments}}</span>
          <span>点赞：{{passage.likes}}</span>
          <span>收藏：{{passage.collections}}</span>
        </div>
        <div class="passage-labels-container">
          <div class="passage-label" :style="{background: label.bgc}" v-for="label in passage.labels" :key="label.id">
            {{label.name}}
          </div>
        </div>
      </div>
    </div>

  </div>
</template>
<script>
import ThemeList from './themeList.vue'
export default {
  components: {
    'ThemeList': ThemeList
  },
  data () {
    return {
      passages: [
        {
          id: 1,
          title: '这是标题',
          author: 'admin',
          content: 'this is a passage,this is a passage,this is a passage,this is a passage,this is a passage,this is a passage,',
          avatar: require('@/assets/imgs/default-avatar.jpg'),
          cover:  require('@/assets/imgs/default-cover.jpg'),
          publicTime: '2021-12-11 12:09:20',
          views: 100,
          comments: 215,
          likes: 142,
          collections: 351,
          labels: [
            {id: 1, name: 'Artery', bgc: '#409EFF'},
            {id: 2, name: 'Vue', bgc: '#67C23A'}
          ]
        },
        {
          id: 1,
          title: 'title',
          author: 'admin',
          content: 'this is a passage,this is a passage,this is a passage,this is a passage,this is a passage,this is a passage,',
          avatar: require('@/assets/imgs/default-avatar.jpg'),
          cover:  require('@/assets/imgs/default-cover.jpg'),
          publicTime: '2021-12-11',
          views: 100,
          comments: 215,
          likes: 142,
          collections: 351,
          labels: [
            {id: 1, name: 'Artery', bgc: '#409EFF'},
            {id: 2, name: 'Vue', bgc: '#67C23A'}
          ]
        },
        {
          id: 1,
          title: 'title',
          author: 'admin',
          content: 'this is a passage,this is a passage,this is a passage,this is a passage,this is a passage,this is a passage,',
          avatar: require('@/assets/imgs/default-avatar.jpg'),
          cover:  require('@/assets/imgs/default-cover.jpg'),
          publicTime: '2021-12-11',
          views: 100,
          comments: 215,
          likes: 142,
          collections: 351,
          labels: [
            {id: 1, name: 'Artery', bgc: '#409EFF'},
            {id: 2, name: 'Vue', bgc: '#67C23A'}
          ]
        },
      ],
      
    }
  }
}
</script>
<style lang="less" scoped>
.content-container{
  .content-passage-container{
    .passage:hover {
      animation: bounce 1s;
    }
    .passage{
      width: calc(100% - 20px);
      background-color: rgba(255, 255, 255, 0.1);
      height: 200px;
      border-radius: 20px;
      overflow: hidden;
      margin-bottom: 20px;
      position: relative;
      display: inline-block;
      margin-right: 20px;
      cursor: pointer;
      .passage-labels-container{
        padding-left: 100px;
        margin-top: 10px;
        .passage-label{
          display: inline-block;
          font-size: 12px;
          margin-right: 10px;
          padding: 8px;
          border-radius: 10px;
          color: #fff;
        }
      }
      .passage-info{
        padding-left: 100px;
        margin-top: 5px;
        font-size: 14px;
        span{
          color: #747480;
          margin-right: 15px;
        }
      }
      .passage-public-info{
        margin-top: 5px;
        padding-left: 100px;
        color: #747480;
      }
      .passage-title{
        position: absolute;
        padding-left: 100px;
        font-size: 24px;
        height: 30px;
        line-height: 30px;
        top: 65px;
        text-shadow:3px 3px 3px #000000;
        color: #fff;
      }
      .passage-author-avatar{
        width: 70px;
        height: 70px;
        border-radius: 35px;
        overflow: hidden;
        border: 1px solid #fff;
        position: absolute;
        top: 65px;
        left: 10px;
        img{
          width: 100%;
          height: 100%;
        }
      }
      .passage-cover{
        width: 100%;
        height: 50%;
        img{
          width: 100%;
          height: 100%;
          filter: blur(5px);
        }
      }
    }
  }
  
}
</style>