<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','service_provider') || ($check_field('add','service_provider') || $check_field('set','service_provider'))" label="服务商" name="service_provider">
                    <uni-data-select
                  id="form_service_provider"
                  v-model="form['service_provider']"
                  :localdata="list_user_service_provider"
                  :clear="!disabledObj['service_provider_isDisabled']"
                  :disabled="disabledObj['service_provider_isDisabled']"
                  v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_provider')) || (!form['life_services_id'] && $check_field('add','service_provider'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['service_provider']"
                  :localdata="list_user_service_provider"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','service_provider')" id="service_provider"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','corporate_name') || ($check_field('add','corporate_name') || $check_field('set','corporate_name'))" label="公司名称" name="corporate_name">
                            <uni-easyinput type="text" v-model="form['corporate_name']" v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','corporate_name')) || (!form['life_services_id'] && $check_field('add','corporate_name'))" :disabled="disabledObj['corporate_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','corporate_name')">
                  {{ form['corporate_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','service_name') || ($check_field('add','service_name') || $check_field('set','service_name'))" label="服务名称" name="service_name">
                            <uni-easyinput type="text" v-model="form['service_name']" v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_name')) || (!form['life_services_id'] && $check_field('add','service_name'))" :disabled="disabledObj['service_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','service_name')">
                  {{ form['service_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','service_type') || ($check_field('add','service_type') || $check_field('set','service_type'))" label="服务类型" name="service_type">
                    <uni-data-select
                  v-model="form.service_type"
                  :localdata="list_service_type"
                  :clear="!disabledObj['service_type_isDisabled']"
                  :disabled="disabledObj['service_type_isDisabled']"
                  v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_type')) || (!form['life_services_id'] && $check_field('add','service_type'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','service_type')">
                  {{ form['service_type'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','cover_photo') || ($check_field('add','cover_photo') || $check_field('set','cover_photo'))" label="封面图片" name="cover_photo">
                    <!-- 修改权限 -->
                <view class="diy_field diy_img" v-if="form['cover_photo'] && $check_field('set','cover_photo')">
                  <image v-if="disabledObj['cover_photo_isDisabled']" :src="$fullUrl(form['cover_photo'])" />
                  <image v-if="!disabledObj['cover_photo_isDisabled']" :src="$fullUrl(form['cover_photo'])" @click="change_img('cover_photo')" />
                </view>
                <!-- 添加权限 -->
                <view class="diy_field diy_img" v-else-if="!form['cover_photo'] && $check_field('add','cover_photo')">
                  <view v-if="disabledObj['cover_photo_isDisabled']" class="btn_add_img">
                    <text>+</text>
                  </view>
                  <view v-if="!disabledObj['cover_photo_isDisabled']" class="btn_add_img" @click="change_img('cover_photo')">
                    <text>+</text>
                  </view>
                </view>
                <!-- 查询权限 -->
                <view class="diy_field diy_img" v-else-if="$check_field('get','cover_photo')">
                  <image :src="$fullUrl(form['cover_photo'])" />
                </view>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','service_price') || ($check_field('add','service_price') || $check_field('set','service_price'))" label="服务价格" name="service_price">
                            <uni-easyinput type="text" v-model="form['service_price']" v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_price')) || (!form['life_services_id'] && $check_field('add','service_price'))" :disabled="disabledObj['service_price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','service_price')">
                  {{ form['service_price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','service_details') || ($check_field('add','service_details') || $check_field('set','service_details'))" label="服务详情" name="service_details">
                    <uni-easyinput type="textarea" v-model="form['service_details']" v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_details')) || (!form['life_services_id'] && $check_field('add','service_details'))" :disabled="disabledObj['service_details_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','service_details')">
                  {{ form['service_details'] }}
                </text>
                  </uni-forms-item>


            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()" class="primary_btn">提交</button>
              <button size="mini" @click="cancel()">取消</button>
            </view>
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";

export default {
  mixins: [mixin],
  data() {
    return {
      field: "life_services_id",
      url_add: "~/api/life_services/add?",
      url_set: "~/api/life_services/set?",
      url_get_obj: "~/api/life_services/get_obj?",
      url_upload: "~/api/life_services/upload?",

      query: {
        "life_services_id": 0,
      },

      form: {
            "service_provider": 0, // 服务商
                    "corporate_name":  '', // 公司名称
                    "service_name":  '', // 服务名称
                    "service_type":  '', // 服务类型
                    "cover_photo":  '', // 封面图片
                    "service_price":  '', // 服务价格
                    "service_details":  '', // 服务详情
                                "life_services_id": 0, // ID
                
              },
          disabledObj:{
                        "service_provider_isDisabled": false,
                                "corporate_name_isDisabled": false,
                                "service_name_isDisabled": false,
                                "service_type_isDisabled": false,
                                "cover_photo_isDisabled": false,
                                "service_price_isDisabled": false,
                                "service_details_isDisabled": false,
                                  },
                                // 用户列表
            list_user_service_provider: [],
                        // 用户组
            group_user_service_provider: "",
                                                                                  // 服务类型选项列表
          list_service_type: [],
                                                                                                  }
  },
  methods: {
    changeLog(v,value){
      this.form[value] = v
    },
    /**
     * 上传文件
     * @param {Object} param文件参数
     */
    change_file(key_name){
      var _self = this;
      // 选择图像方法
      uni.chooseFile({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/life_services/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
            }
          });

          uploadTask.onProgressUpdate(function(res) {
            _self.percent = res.progress;
            console.log('上传进度' + res.progress);
            console.log('已经上传的数据长度' + res.totalBytesSent);
            console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
          });
        },
        error: function(e) {
          console.log(e);
        }
      });
    },
    /**
     * 上传图片
     * @param {Object} param文件参数
     */
    change_img(key_name){
      var _self = this;
      _self.upload_img_flag = false
      // 选择图像方法
      uni.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/life_services/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
            }
          });

          uploadTask.onProgressUpdate(function(res) {
            _self.percent = res.progress;
            console.log('上传进度' + res.progress);
            console.log('已经上传的数据长度' + res.totalBytesSent);
            console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
          });
        },
        error: function(e) {
          console.log(e);
        }
      });
    },
    /**
     * 获取对象后获取缓存表单
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_before(param){
      var form = uni.db.get("form");
      if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
        this.obj = uni.push(this.obj ,form);
        this.form = uni.push(this.form ,form);
      }
      var arr = []
      for (let key in form) {
        arr.push(key)
      }
      for (var i=0;i<arr.length;i++){
        this.disabledObj[arr[i] + '_isDisabled'] = true
      }
                                                              uni.db.del("form");
      return param;
    },
            /**
     * 获取服务商用户列表
     */
    async get_list_user_service_provider() {
      // if(this.user_group !== "管理员" && this.form["service_provider"] === 0) {
      //     this.form["service_provider"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=服务商");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_service_provider.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            /**
     * 获取服务商用户组
     */
    async get_group_user_service_provider() {
      this.form["service_provider"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=服务商");
      if(json.result && json.result.obj){
        this.group_user_service_provider = json.result.obj;
        this.get_user_session_service_provider(this.form['service_provider'])
      }
      else if(json.error){
        console.error(json.error);
      }
    },
    get_user_session_service_provider(id){
      var _this = this;
      var user_id = {"user_id":id}
      var url = "~/api/"+_this.group_user_service_provider.source_table+"/get_obj?"
      this.$get(url, user_id, function(res) {
        if (res.result && res.result.obj) {
          var arr = []
          for (let key in res.result.obj) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in _this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arr[i] === arrForm[j]) {
                  if (arr[i] !== "service_provider") {
                    _this.form[arrForm[j]] = res.result.obj[arr[i]]
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                    break;
                  } else {
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  }
                }
              }
            }
          }
        }
      });
    },
            
            
            
            /**
     * 获取服务类型列表
     */
    async get_list_service_type() {
              var json = await this.$get("~/api/service_classification/get_list?");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_service_type.push({value:o.service_type,text:o.service_type}));
      }
      else if(json.error){
        console.error(json.error);
      }
        },
        
            
            
            
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                            },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/life_services/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/life_services/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/life_services/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/life_services/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/life_services/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
            this.get_list_user_service_provider();
            this.get_group_user_service_provider();
                                    this.get_list_service_type();
                                  },
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.form_button{
  padding-bottom: 15px;
  display: flex;
}
.form_button button{
  width: 40%;
}
.query_select{
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline:none;
}

.query_option{
  width: 100%;
}

.btn_add_img{
  color: #D3D3D3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text{
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.form_button {
  padding-bottom: 15px;
  display: flex;
}
.form_button button {
  width: 40%;
}
.query_select {
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline: none;
}

.query_option {
  width: 100%;
}

.btn_add_img {
  color: #d3d3d3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text {
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
/*新样式*/
.uni-forms{
padding-top:1rem;
}
.uni-forms-item {
	padding: 6px 10px;
    background: #f8f6fc;
}
.uni-forms .is-input-border{
	border: 0;
}
.container{
	    -webkit-box-shadow: 0px 0px 0px #888888;
	    box-shadow: 0px 0px 0px #888888;
}
.form_button .primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
</style>
