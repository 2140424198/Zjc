<template>
	<view class="bgi">
		<div>
			<ul class="header">
				<li class="category-item" v-for="(lineCategory, index) in lineData" :key="index" @click="show(index)">
					{{index}}
				</li>
			</ul>
			<div v-for="(lineCategory, index) in lineData" :key="index" v-show="showArea[index]">
				<div v-for="(lineInfo, ind) in lineCategory" class="line">
					<image v-if="lineInfo.img" :src="`${backendURL}/img/show/${lineInfo.img}`"></image>
					<div>线路名称：{{lineInfo.lineName}}</div>
					<div>线路金额：<span class="qqq">￥</span>{{lineInfo.lineAmount}}</div>
					<div>线路简介：{{lineInfo.remark}}</div>
					<button class="btn" @click="toDetail(lineInfo.id)">立即订购</button>
				</div>
			</div>
		</div>

	</view>

</template>

<script>
	export default {
		data() {
			return {
				backendURL: this.backendURL,
				lineData: {},
				showArea: {}
			}
		},
		methods: {
			show(id) {
				for (let item in this.showArea) {
					this.showArea[item] = false;
				}
				this.showArea[id] = true;
			},
			toDetail(id) {
				console.log(id)
				uni.redirectTo({
					url: './detaile?id='+id
				});
			}
		},
		mounted() {
			this.$axios({
				method: 'get',
				url: '/line/fetchLineByCategory'
			}).then(res => {
				this.lineData = res.data;
				let i = 0;
				for (let item in this.lineData) {
					if (i == 0) {
						this.$set(this.showArea, item, true);
					} else {
						this.$set(this.showArea, item, false);
					}
					i++;
				}
			}).catch(err => {
				console.log(err)
			})
		}
	}
</script>

<style>
	.qqq{
		color: red;
	}
	.btn{
		width: 100px;
		border: none;
		opacity: 0.7;
	}
	.bgi{
		background-color: #fff;
		font-family: SimSun;
		background-image: url(https://img1.baidu.com/it/u=1111504032,3793788730&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500);
		background-size: contain;
		font-weight: 550;
	}
	.header {
		display: -webkit-flex; //标示使用flexbox弹性盒子
		color: #fff;
		text-align: center;
		width: 100%;
		height: 40px;
		line-height: 40px;
		font-size: 16px;
	}

	.category-item {
		flex: 1;
		background-color: skyblue;
		border: 1px solid #fff;
		border-radius: 50px;
		margin: 1px;
	}

	.show {
		display: block;
	}

	.hidle {
		display: none;
	}

	.line {
		height: 260px;
	}

	image {
		height: 150px;
	}
</style>
