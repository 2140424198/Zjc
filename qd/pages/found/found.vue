<template>
	<view class="bgi">
		<uni-calendar ref="calendar" :insert="false" @confirm="confirm" />
		<view class="uni-form-item uni-column search" >
			<input class="uni-input" confirm-type="search" placeholder="搜索景点" v-model="searchValue" /><icon class="icon" type="search" size="24" @click="search"/>
		</view>
		<view>
			<div class='datou'>{{foundInfo.scenicName}}</div>
			<h3>地址：</h3>
			<div class="add">{{foundInfo.scenicAddress}}</div>
			<h3>简介：</h3>
			<div class="add">{{foundInfo.scenicDescribe}}</div>
			<image v-if="foundInfo.scenicImage" :src="`${backendURL}/img/show/${foundInfo.scenicImage}`"></image>
			<template>
				<view>
					<view class="page-body">
						<view class="page-section page-section-gap">
							<map style="width: 100%; height: 200px;" :latitude="foundInfo.latitude"
								:longitude="foundInfo.longitude" :markers="covers">
							</map>
						</view>
					</view>
				</view>
			</template>

		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				backendURL: this.backendURL,
				foundInfo: {},
				searchValue: ''
			};
		},
		methods: {
			open() {
				this.$refs.calendar.open();
			},
			confirm(e) {
				console.log(e);
			},
			fetchFoundInfo() {
				this.$axios({
					method: 'get',
					url: '/index/foundInfo',
				}).then(res => {
					this.foundInfo = res.data;
				}).catch(err => {
					console.log(err)
				})
			},
			search() {
				console.log("========", this.searchValue)
				this.$axios({
					method: 'get',
					url: '/index/search',
					params: {scenicName: this.searchValue}
				}).then(res => {
					this.foundInfo = res.data;
				}).catch(err => {
					console.log(err)
				})
			}
		},
		mounted() {
			this.fetchFoundInfo()
		}
	}
</script>

<style>
	.bgi{
		background: linear-gradient(to right, rgb(247, 209, 215), rgb(191, 227, 241));
		font-family: 'SimSun';
	}
	.datou{
		margin: 10px;
		font-weight: 700;
	}
	.add{
		margin: 10px;
	}
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: groy;
	}

	.img image {
		margin: auto;
		display: block;
	}
	
	.search {
		display: flex;
	}
	.uni-input{
		margin: 10px;
		box-sizing: border-box;
		padding-left: 10px;
		border: 1px solid #fdffdd;
		border-radius: 50px;
		color: black;
	}
	.icon{
		margin: 10px 10px;
	}
</style>
