# 24w19b (Snapshot)
| Series | Java Runtime | Java Version | Protocol Version | World Version | Resource Pack Version | Data Pack Version | Build Timestamp (UTC) |
| -------------| -------------| -------------| -------------| -------------| -------------| -------------| -------------|
| main| java-runtime-delta| 21| 1073742019| 3942| 33| 43| 10/05/2024 14:30:02|
## Handshake (Serverbound)
#### 0x00 - Client Intention (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| protocolVersion| int| int|
| 1| 0| hostName| String| String|
| 2| 1| port| int| int|
| 3| 0| intention| ClientIntent| ClientIntent|
 
## Status (Clientbound)
#### 0x00 - Status Response (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| status| ServerStatus| ServerStatus|
 
#### 0x01 - Pong Response (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
## Status (Serverbound)
#### 0x00 - Status Request (C ➔ S)
Packet has no fields
 
#### 0x01 - Ping Request (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
## Login (Clientbound)
#### 0x00 - Login Disconnect (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x01 - Hello (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| serverId| String| String|
| 1| 0| publicKey| byte[]| byte[]|
| 2| 1| challenge| byte[]| byte[]|
| 3| 0| shouldAuthenticate| boolean| boolean|
 
#### 0x02 - Game Profile (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| gameProfile| GameProfile| GameProfile|
| 1| 0| strictErrorHandling| boolean| boolean|
 
#### 0x03 - Login Compression (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| compressionThreshold| int| int|
 
#### 0x04 - Custom Query (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| payload| CustomQueryPayload| CustomQueryPayload|
 
#### 0x05 - Cookie Request (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
 
## Login (Serverbound)
#### 0x00 - Hello (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| String| String|
| 1| 0| profileId| UUID| UUID|
 
#### 0x01 - Key (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| keybytes| byte[]| byte[]|
| 1| 1| encryptedChallenge| byte[]| byte[]|
 
#### 0x02 - Custom Query Answer (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| payload| CustomQueryAnswerPayload| CustomQueryAnswerPayload|
 
#### 0x03 - Login Acknowledged (C ➔ S)
Packet has no fields
 
#### 0x04 - Cookie Response (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
| 1| 0| payload| byte[]| byte[]|
 
## Configuration (Clientbound)
#### 0x00 - Cookie Request (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
 
#### 0x01 - Custom Payload (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x02 - Disconnect (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x03 - Finish Configuration (S ➔ C)
Packet has no fields
 
#### 0x04 - Keep Alive (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x05 - Ping (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x06 - Reset Chat (S ➔ C)
Packet has no fields
 
#### 0x07 - Registry Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| registry| ResourceKey| ResourceKey&lt;? extends Registry&lt;?&gt;&gt;|
| 1| 0| entries| List| List&lt;RegistrySynchronization$PackedRegistryEntry&gt;|
 
#### 0x08 - Resource Pack Pop (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| Optional| Optional&lt;UUID&gt;|
 
#### 0x09 - Resource Pack Push (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| url| String| String|
| 2| 1| hash| String| String|
| 3| 0| required| boolean| boolean|
| 4| 0| prompt| Optional| Optional&lt;Component&gt;|
 
#### 0x0A - Store Cookie (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
| 1| 0| payload| byte[]| byte[]|
 
#### 0x0B - Transfer (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| host| String| String|
| 1| 0| port| int| int|
 
#### 0x0C - Update Enabled Features (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| features| Set| Set&lt;ResourceLocation&gt;|
 
#### 0x0D - Update Tags (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tags| Map| Map&lt;ResourceKey&lt;? extends Registry&lt;?&gt;&gt;, TagNetworkSerialization$NetworkPayload&gt;|
 
#### 0x0E - Select Known Packs (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| knownPacks| List| List&lt;KnownPack&gt;|
 
## Configuration (Serverbound)
#### 0x00 - Client Information (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| information| ClientInformation| ClientInformation|
 
#### 0x01 - Cookie Response (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
| 1| 0| payload| byte[]| byte[]|
 
#### 0x02 - Custom Payload (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x03 - Finish Configuration (C ➔ S)
Packet has no fields
 
#### 0x04 - Keep Alive (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x05 - Pong (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x06 - Resource Pack (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| action| ServerboundResourcePackPacket$Action| ServerboundResourcePackPacket$Action|
 
#### 0x07 - Select Known Packs (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| knownPacks| List| List&lt;KnownPack&gt;|
 
## Game (Clientbound)
#### 0x00 - Bundle Delimiter (S ➔ C)
Packet has no fields
 
#### 0x01 - Add Entity (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| uuid| UUID| UUID|
| 2| 0| type| EntityType| EntityType&lt;?&gt;|
| 3| 0| x| double| double|
| 4| 1| y| double| double|
| 5| 2| z| double| double|
| 6| 1| xa| int| int|
| 7| 2| ya| int| int|
| 8| 3| za| int| int|
| 9| 0| xRot| byte| byte|
| 10| 1| yRot| byte| byte|
| 11| 2| yHeadRot| byte| byte|
| 12| 4| data| int| int|
 
#### 0x02 - Add Experience Orb (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| x| double| double|
| 2| 1| y| double| double|
| 3| 2| z| double| double|
| 4| 1| value| int| int|
 
#### 0x03 - Animate (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| action| int| int|
 
#### 0x04 - Award Stats (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| stats| Object2IntMap| Object2IntMap&lt;Stat&lt;?&gt;&gt;|
 
#### 0x05 - Block Changed Ack (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sequence| int| int|
 
#### 0x06 - Block Destruction (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| pos| BlockPos| BlockPos|
| 2| 1| progress| int| int|
 
#### 0x07 - Block Entity Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| type| BlockEntityType| BlockEntityType&lt;?&gt;|
| 2| 0| tag| CompoundTag| CompoundTag|
 
#### 0x08 - Block Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| b0| int| int|
| 2| 1| b1| int| int|
| 3| 0| block| Block| Block|
 
#### 0x09 - Block Update (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| blockState| BlockState| BlockState|
 
#### 0x0A - Boss Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| operation| ClientboundBossEventPacket$Operation| ClientboundBossEventPacket$Operation|
 
#### 0x0B - Change Difficulty (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| difficulty| Difficulty| Difficulty|
| 1| 0| locked| boolean| boolean|
 
#### 0x0C - Chunk Batch Finished (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| batchSize| int| int|
 
#### 0x0D - Chunk Batch Start (S ➔ C)
Packet has no fields
 
#### 0x0E - Chunks Biomes (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| chunkBiomeData| List| List&lt;ClientboundChunksBiomesPacket$ChunkBiomeData&gt;|
 
#### 0x0F - Clear Titles (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| resetTimes| boolean| boolean|
 
#### 0x10 - Command Suggestions (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| start| int| int|
| 2| 2| length| int| int|
| 3| 0| suggestions| List| List&lt;ClientboundCommandSuggestionsPacket$Entry&gt;|
 
#### 0x11 - Commands (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| rootIndex| int| int|
| 1| 0| entries| List| List&lt;ClientboundCommandsPacket$Entry&gt;|
 
#### 0x12 - Container Close (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
 
#### 0x13 - Container Set Content (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 0| items| List| List&lt;ItemStack&gt;|
| 3| 0| carriedItem| ItemStack| ItemStack|
 
#### 0x14 - Container Set Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| id| int| int|
| 2| 2| value| int| int|
 
#### 0x15 - Container Set Slot (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 2| slot| int| int|
| 3| 0| itemStack| ItemStack| ItemStack|
 
#### 0x16 - Cookie Request (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
 
#### 0x17 - Cooldown (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| item| Item| Item|
| 1| 0| duration| int| int|
 
#### 0x18 - Custom Chat Completions (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ClientboundCustomChatCompletionsPacket$Action| ClientboundCustomChatCompletionsPacket$Action|
| 1| 0| entries| List| List&lt;String&gt;|
 
#### 0x19 - Custom Payload (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x1A - Damage Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| sourceType| Holder| Holder&lt;DamageType&gt;|
| 2| 1| sourceCauseId| int| int|
| 3| 2| sourceDirectId| int| int|
| 4| 0| sourcePosition| Optional| Optional&lt;Vec3&gt;|
 
#### 0x1B - Debug Sample (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sample| long[]| long[]|
| 1| 0| debugSampleType| RemoteDebugSampleType| RemoteDebugSampleType|
 
#### 0x1C - Delete Chat (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| messageSignature| MessageSignature$Packed| MessageSignature$Packed|
 
#### 0x1D - Disconnect (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x1E - Disguised Chat (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| message| Component| Component|
| 1| 0| chatType| ChatType$Bound| ChatType$Bound|
 
#### 0x1F - Entity Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| eventId| byte| byte|
 
#### 0x20 - Explode (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| power| float| float|
| 4| 0| toBlow| List| List&lt;BlockPos&gt;|
| 5| 1| knockbackX| float| float|
| 6| 2| knockbackY| float| float|
| 7| 3| knockbackZ| float| float|
| 8| 0| smallExplosionParticles| ParticleOptions| ParticleOptions|
| 9| 1| largeExplosionParticles| ParticleOptions| ParticleOptions|
| 10| 0| blockInteraction| Explosion$BlockInteraction| Explosion$BlockInteraction|
| 11| 0| explosionSound| Holder| Holder&lt;SoundEvent&gt;|
 
#### 0x21 - Forget Level Chunk (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| ChunkPos| ChunkPos|
 
#### 0x22 - Game Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| event| ClientboundGameEventPacket$Type| ClientboundGameEventPacket$Type|
| 1| 0| param| float| float|
 
#### 0x23 - Horse Screen Open (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| size| int| int|
| 2| 2| entityId| int| int|
 
#### 0x24 - Hurt Animation (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| yaw| float| float|
 
#### 0x25 - Initialize Border (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| newCenterX| double| double|
| 1| 1| newCenterZ| double| double|
| 2| 2| oldSize| double| double|
| 3| 3| newSize| double| double|
| 4| 0| lerpTime| long| long|
| 5| 0| newAbsoluteMaxSize| int| int|
| 6| 1| warningBlocks| int| int|
| 7| 2| warningTime| int| int|
 
#### 0x26 - Keep Alive (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x27 - Level Chunk With Light (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| chunkData| ClientboundLevelChunkPacketData| ClientboundLevelChunkPacketData|
| 3| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x28 - Level Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| type| int| int|
| 1| 0| pos| BlockPos| BlockPos|
| 2| 1| data| int| int|
| 3| 0| globalEvent| boolean| boolean|
 
#### 0x29 - Level Particles (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| xDist| float| float|
| 4| 1| yDist| float| float|
| 5| 2| zDist| float| float|
| 6| 3| maxSpeed| float| float|
| 7| 0| count| int| int|
| 8| 0| overrideLimiter| boolean| boolean|
| 9| 0| particle| ParticleOptions| ParticleOptions|
 
#### 0x2A - Light Update (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x2B - Login (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| playerId| int| int|
| 1| 0| hardcore| boolean| boolean|
| 2| 0| levels| Set| Set&lt;ResourceKey&lt;Level&gt;&gt;|
| 3| 1| maxPlayers| int| int|
| 4| 2| chunkRadius| int| int|
| 5| 3| simulationDistance| int| int|
| 6| 1| reducedDebugInfo| boolean| boolean|
| 7| 2| showDeathScreen| boolean| boolean|
| 8| 3| doLimitedCrafting| boolean| boolean|
| 9| 0| commonPlayerSpawnInfo| CommonPlayerSpawnInfo| CommonPlayerSpawnInfo|
| 10| 4| enforcesSecureChat| boolean| boolean|
 
#### 0x2C - Map Item Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| mapId| MapId| MapId|
| 1| 0| scale| byte| byte|
| 2| 0| locked| boolean| boolean|
| 3| 0| decorations| Optional| Optional&lt;List&lt;MapDecoration&gt;&gt;|
| 4| 1| colorPatch| Optional| Optional&lt;MapItemSavedData$MapPatch&gt;|
 
#### 0x2D - Merchant Offers (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| offers| MerchantOffers| MerchantOffers|
| 2| 1| villagerLevel| int| int|
| 3| 2| villagerXp| int| int|
| 4| 0| showProgress| boolean| boolean|
| 5| 1| canRestock| boolean| boolean|
 
#### 0x2E - Pos (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| xa| short| short|
| 2| 1| ya| short| short|
| 3| 2| za| short| short|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
| 7| 1| hasRot| boolean| boolean|
| 8| 2| hasPos| boolean| boolean|
 
#### 0x2F - Pos Rot (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| xa| short| short|
| 2| 1| ya| short| short|
| 3| 2| za| short| short|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
| 7| 1| hasRot| boolean| boolean|
| 8| 2| hasPos| boolean| boolean|
 
#### 0x30 - Rot (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| xa| short| short|
| 2| 1| ya| short| short|
| 3| 2| za| short| short|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
| 7| 1| hasRot| boolean| boolean|
| 8| 2| hasPos| boolean| boolean|
 
#### 0x31 - Move Vehicle (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
 
#### 0x32 - Open Book (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x33 - Open Screen (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| type| MenuType| MenuType&lt;?&gt;|
| 2| 0| title| Component| Component|
 
#### 0x34 - Open Sign Editor (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| isFrontText| boolean| boolean|
 
#### 0x35 - Ping (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x36 - Pong Response (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
#### 0x37 - Place Ghost Recipe (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipe| ResourceLocation| ResourceLocation|
 
#### 0x38 - Player Abilities (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| invulnerable| boolean| boolean|
| 1| 1| isFlying| boolean| boolean|
| 2| 2| canFly| boolean| boolean|
| 3| 3| instabuild| boolean| boolean|
| 4| 0| flyingSpeed| float| float|
| 5| 1| walkingSpeed| float| float|
 
#### 0x39 - Player Chat (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sender| UUID| UUID|
| 1| 0| index| int| int|
| 2| 0| signature| MessageSignature| MessageSignature|
| 3| 0| body| SignedMessageBody$Packed| SignedMessageBody$Packed|
| 4| 0| unsignedContent| Component| Component|
| 5| 0| filterMask| FilterMask| FilterMask|
| 6| 0| chatType| ChatType$Bound| ChatType$Bound|
 
#### 0x3A - Player Combat End (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| duration| int| int|
 
#### 0x3B - Player Combat Enter (S ➔ C)
Packet has no fields
 
#### 0x3C - Player Combat Kill (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| playerId| int| int|
| 1| 0| message| Component| Component|
 
#### 0x3D - Player Info Remove (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| profileIds| List| List&lt;UUID&gt;|
 
#### 0x3E - Player Info Update (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| actions| EnumSet| EnumSet&lt;ClientboundPlayerInfoUpdatePacket$Action&gt;|
| 1| 0| entries| List| List&lt;ClientboundPlayerInfoUpdatePacket$Entry&gt;|
 
#### 0x3F - Player Look At (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| entity| int| int|
| 4| 0| fromAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 5| 1| toAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 6| 0| atEntity| boolean| boolean|
 
#### 0x40 - Player Position (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| relativeArguments| Set| Set&lt;RelativeMovement&gt;|
| 6| 0| id| int| int|
 
#### 0x41 - Recipe (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| state| ClientboundRecipePacket$State| ClientboundRecipePacket$State|
| 1| 0| recipes| List| List&lt;ResourceLocation&gt;|
| 2| 1| toHighlight| List| List&lt;ResourceLocation&gt;|
| 3| 0| bookSettings| RecipeBookSettings| RecipeBookSettings|
 
#### 0x42 - Remove Entities (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityIds| IntList| IntList|
 
#### 0x43 - Remove Mob Effect (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| Holder| Holder&lt;MobEffect&gt;|
 
#### 0x44 - Reset Score (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| owner| String| String|
| 1| 1| objectiveName| String| String|
 
#### 0x45 - Resource Pack Pop (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| Optional| Optional&lt;UUID&gt;|
 
#### 0x46 - Resource Pack Push (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| url| String| String|
| 2| 1| hash| String| String|
| 3| 0| required| boolean| boolean|
| 4| 0| prompt| Optional| Optional&lt;Component&gt;|
 
#### 0x47 - Respawn (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| commonPlayerSpawnInfo| CommonPlayerSpawnInfo| CommonPlayerSpawnInfo|
| 1| 0| dataToKeep| byte| byte|
 
#### 0x48 - Rotate Head (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| yHeadRot| byte| byte|
 
#### 0x49 - Section Blocks Update (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sectionPos| SectionPos| SectionPos|
| 1| 0| positions| short[]| short[]|
| 2| 0| states| BlockState[]| BlockState[]|
 
#### 0x4A - Select Advancements Tab (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x4B - Server Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| motd| Component| Component|
| 1| 0| iconBytes| Optional| Optional&lt;byte[]&gt;|
 
#### 0x4C - Set Action Bar Text (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x4D - Set Border Center (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| newCenterX| double| double|
| 1| 1| newCenterZ| double| double|
 
#### 0x4E - Set Border Lerp Size (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| oldSize| double| double|
| 1| 1| newSize| double| double|
| 2| 0| lerpTime| long| long|
 
#### 0x4F - Set Border Size (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| size| double| double|
 
#### 0x50 - Set Border Warning Delay (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningDelay| int| int|
 
#### 0x51 - Set Border Warning Distance (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningBlocks| int| int|
 
#### 0x52 - Set Camera (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| cameraId| int| int|
 
#### 0x53 - Set Carried Item (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x54 - Set Chunk Cache Center (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
 
#### 0x55 - Set Chunk Cache Radius (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| radius| int| int|
 
#### 0x56 - Set Default Spawn Position (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| angle| float| float|
 
#### 0x57 - Set Display Objective (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| DisplaySlot| DisplaySlot|
| 1| 0| objectiveName| String| String|
 
#### 0x58 - Set Entity Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| packedItems| List| List&lt;SynchedEntityData$DataValue&lt;?&gt;&gt;|
 
#### 0x59 - Set Entity Link (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sourceId| int| int|
| 1| 1| destId| int| int|
 
#### 0x5A - Set Entity Motion (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| xa| int| int|
| 2| 2| ya| int| int|
| 3| 3| za| int| int|
 
#### 0x5B - Set Equipment (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| slots| List| List&lt;Pair&lt;EquipmentSlot, ItemStack&gt;&gt;|
 
#### 0x5C - Set Experience (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| experienceProgress| float| float|
| 1| 0| totalExperience| int| int|
| 2| 1| experienceLevel| int| int|
 
#### 0x5D - Set Health (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| health| float| float|
| 1| 0| food| int| int|
| 2| 1| saturation| float| float|
 
#### 0x5E - Set Objective (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| objectiveName| String| String|
| 1| 0| displayName| Component| Component|
| 2| 0| renderType| ObjectiveCriteria$RenderType| ObjectiveCriteria$RenderType|
| 3| 0| numberFormat| Optional| Optional&lt;NumberFormat&gt;|
| 4| 0| method| int| int|
 
#### 0x5F - Set Passengers (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| vehicle| int| int|
| 1| 0| passengers| int[]| int[]|
 
#### 0x60 - Set Player Team (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| method| int| int|
| 1| 0| name| String| String|
| 2| 0| players| Collection| Collection&lt;String&gt;|
| 3| 0| parameters| Optional| Optional&lt;ClientboundSetPlayerTeamPacket$Parameters&gt;|
 
#### 0x61 - Set Score (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| owner| String| String|
| 1| 1| objectiveName| String| String|
| 2| 0| score| int| int|
| 3| 0| display| Optional| Optional&lt;Component&gt;|
| 4| 1| numberFormat| Optional| Optional&lt;NumberFormat&gt;|
 
#### 0x62 - Set Simulation Distance (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| simulationDistance| int| int|
 
#### 0x63 - Set Subtitle Text (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x64 - Set Time (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| gameTime| long| long|
| 1| 1| dayTime| long| long|
 
#### 0x65 - Set Title Text (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x66 - Set Titles Animation (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| fadeIn| int| int|
| 1| 1| stay| int| int|
| 2| 2| fadeOut| int| int|
 
#### 0x67 - Sound Entity (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sound| Holder| Holder&lt;SoundEvent&gt;|
| 1| 0| source| SoundSource| SoundSource|
| 2| 0| id| int| int|
| 3| 0| volume| float| float|
| 4| 1| pitch| float| float|
| 5| 0| seed| long| long|
 
#### 0x68 - Sound (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sound| Holder| Holder&lt;SoundEvent&gt;|
| 1| 0| source| SoundSource| SoundSource|
| 2| 0| x| int| int|
| 3| 1| y| int| int|
| 4| 2| z| int| int|
| 5| 0| volume| float| float|
| 6| 1| pitch| float| float|
| 7| 0| seed| long| long|
 
#### 0x69 - Start Configuration (S ➔ C)
Packet has no fields
 
#### 0x6A - Stop Sound (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| ResourceLocation| ResourceLocation|
| 1| 0| source| SoundSource| SoundSource|
 
#### 0x6B - Store Cookie (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
| 1| 0| payload| byte[]| byte[]|
 
#### 0x6C - System Chat (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| content| Component| Component|
| 1| 0| overlay| boolean| boolean|
 
#### 0x6D - Tab List (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| header| Component| Component|
| 1| 1| footer| Component| Component|
 
#### 0x6E - Tag Query (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| tag| CompoundTag| CompoundTag|
 
#### 0x6F - Take Item Entity (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| itemId| int| int|
| 1| 1| playerId| int| int|
| 2| 2| amount| int| int|
 
#### 0x70 - Teleport Entity (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| x| double| double|
| 2| 1| y| double| double|
| 3| 2| z| double| double|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
 
#### 0x71 - Ticking State (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tickRate| float| float|
| 1| 0| isFrozen| boolean| boolean|
 
#### 0x72 - Ticking Step (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tickSteps| int| int|
 
#### 0x73 - Transfer (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| host| String| String|
| 1| 0| port| int| int|
 
#### 0x74 - Update Advancements (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reset| boolean| boolean|
| 1| 0| added| List| List&lt;AdvancementHolder&gt;|
| 2| 0| removed| Set| Set&lt;ResourceLocation&gt;|
| 3| 0| progress| Map| Map&lt;ResourceLocation, AdvancementProgress&gt;|
 
#### 0x75 - Update Attributes (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| attributes| List| List&lt;ClientboundUpdateAttributesPacket$AttributeSnapshot&gt;|
 
#### 0x76 - Update Mob Effect (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| Holder| Holder&lt;MobEffect&gt;|
| 2| 1| effectAmplifier| int| int|
| 3| 2| effectDurationTicks| int| int|
| 4| 0| flags| byte| byte|
 
#### 0x77 - Update Recipes (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipes| List| List&lt;RecipeHolder&lt;?&gt;&gt;|
 
#### 0x78 - Update Tags (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tags| Map| Map&lt;ResourceKey&lt;? extends Registry&lt;?&gt;&gt;, TagNetworkSerialization$NetworkPayload&gt;|
 
#### 0x79 - Projectile Power (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| accelerationPower| double| double|
 
## Game (Serverbound)
#### 0x00 - Accept Teleportation (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x01 - Block Entity Tag Query (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| pos| BlockPos| BlockPos|
 
#### 0x02 - Change Difficulty (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| difficulty| Difficulty| Difficulty|
 
#### 0x03 - Chat Ack (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| offset| int| int|
 
#### 0x04 - Chat Command (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| command| String| String|
 
#### 0x05 - Chat Command Signed (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| command| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| argumentSignatures| ArgumentSignatures| ArgumentSignatures|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x06 - Chat (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| message| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| signature| MessageSignature| MessageSignature|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x07 - Chat Session Update (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| chatSession| RemoteChatSession$Data| RemoteChatSession$Data|
 
#### 0x08 - Chunk Batch Received (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| desiredChunksPerTick| float| float|
 
#### 0x09 - Client Command (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundClientCommandPacket$Action| ServerboundClientCommandPacket$Action|
 
#### 0x0A - Client Information (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| information| ClientInformation| ClientInformation|
 
#### 0x0B - Command Suggestion (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| command| String| String|
 
#### 0x0C - Configuration Acknowledged (C ➔ S)
Packet has no fields
 
#### 0x0D - Container Button Click (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| buttonId| int| int|
 
#### 0x0E - Container Click (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 2| slotNum| int| int|
| 3| 3| buttonNum| int| int|
| 4| 0| clickType| ClickType| ClickType|
| 5| 0| carriedItem| ItemStack| ItemStack|
| 6| 0| changedSlots| Int2ObjectMap| Int2ObjectMap&lt;ItemStack&gt;|
 
#### 0x0F - Container Close (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
 
#### 0x10 - Container Slot State Changed (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotId| int| int|
| 1| 1| containerId| int| int|
| 2| 0| newState| boolean| boolean|
 
#### 0x11 - Cookie Response (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
| 1| 0| payload| byte[]| byte[]|
 
#### 0x12 - Custom Payload (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x13 - Debug Sample Subscription (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sampleType| RemoteDebugSampleType| RemoteDebugSampleType|
 
#### 0x14 - Edit Book (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
| 1| 0| pages| List| List&lt;String&gt;|
| 2| 0| title| Optional| Optional&lt;String&gt;|
 
#### 0x15 - Entity Tag Query (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 1| entityId| int| int|
 
#### 0x16 - Interact (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| action| ServerboundInteractPacket$Action| ServerboundInteractPacket$Action|
| 2| 0| usingSecondaryAction| boolean| boolean|
 
#### 0x17 - Jigsaw Generate (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| levels| int| int|
| 2| 0| keepJigsaws| boolean| boolean|
 
#### 0x18 - Keep Alive (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x19 - Lock Difficulty (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| locked| boolean| boolean|
 
#### 0x1A - Pos (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x1B - Pos Rot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x1C - Rot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x1D - Status Only (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x1E - Move Vehicle (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
 
#### 0x1F - Paddle Boat (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| left| boolean| boolean|
| 1| 1| right| boolean| boolean|
 
#### 0x20 - Pick Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x21 - Ping Request (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
#### 0x22 - Place Recipe (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipe| ResourceLocation| ResourceLocation|
| 2| 0| shiftDown| boolean| boolean|
 
#### 0x23 - Player Abilities (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| isFlying| boolean| boolean|
 
#### 0x24 - Player Action (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| direction| Direction| Direction|
| 2| 0| action| ServerboundPlayerActionPacket$Action| ServerboundPlayerActionPacket$Action|
| 3| 0| sequence| int| int|
 
#### 0x25 - Player Command (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| action| ServerboundPlayerCommandPacket$Action| ServerboundPlayerCommandPacket$Action|
| 2| 1| data| int| int|
 
#### 0x26 - Player Input (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| xxa| float| float|
| 1| 1| zza| float| float|
| 2| 0| isJumping| boolean| boolean|
| 3| 1| isShiftKeyDown| boolean| boolean|
 
#### 0x27 - Pong (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x28 - Recipe Book Change Settings (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| bookType| RecipeBookType| RecipeBookType|
| 1| 0| isOpen| boolean| boolean|
| 2| 1| isFiltering| boolean| boolean|
 
#### 0x29 - Recipe Book Seen Recipe (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipe| ResourceLocation| ResourceLocation|
 
#### 0x2A - Rename Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| String| String|
 
#### 0x2B - Resource Pack (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| action| ServerboundResourcePackPacket$Action| ServerboundResourcePackPacket$Action|
 
#### 0x2C - Seen Advancements (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundSeenAdvancementsPacket$Action| ServerboundSeenAdvancementsPacket$Action|
| 1| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x2D - Select Trade (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| item| int| int|
 
#### 0x2E - Set Beacon (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| primary| Optional| Optional&lt;Holder&lt;MobEffect&gt;&gt;|
| 1| 1| secondary| Optional| Optional&lt;Holder&lt;MobEffect&gt;&gt;|
 
#### 0x2F - Set Carried Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x30 - Set Command Block (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
| 3| 1| conditional| boolean| boolean|
| 4| 2| automatic| boolean| boolean|
| 5| 0| mode| CommandBlockEntity$Mode| CommandBlockEntity$Mode|
 
#### 0x31 - Set Command Minecart (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
 
#### 0x32 - Set Creative Mode Slot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotNum| short| short|
| 1| 0| itemStack| ItemStack| ItemStack|
 
#### 0x33 - Set Jigsaw Block (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| name| ResourceLocation| ResourceLocation|
| 2| 1| target| ResourceLocation| ResourceLocation|
| 3| 2| pool| ResourceLocation| ResourceLocation|
| 4| 0| finalState| String| String|
| 5| 0| joint| JigsawBlockEntity$JointType| JigsawBlockEntity$JointType|
| 6| 0| selectionPriority| int| int|
| 7| 1| placementPriority| int| int|
 
#### 0x34 - Set Structure Block (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| updateType| StructureBlockEntity$UpdateType| StructureBlockEntity$UpdateType|
| 2| 0| mode| StructureMode| StructureMode|
| 3| 0| name| String| String|
| 4| 1| offset| BlockPos| BlockPos|
| 5| 0| size| Vec3i| Vec3i|
| 6| 0| mirror| Mirror| Mirror|
| 7| 0| rotation| Rotation| Rotation|
| 8| 1| data| String| String|
| 9| 0| ignoreEntities| boolean| boolean|
| 10| 1| showAir| boolean| boolean|
| 11| 2| showBoundingBox| boolean| boolean|
| 12| 0| integrity| float| float|
| 13| 0| seed| long| long|
 
#### 0x35 - Sign Update (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| lines| String[]| String[]|
| 2| 0| isFrontText| boolean| boolean|
 
#### 0x36 - Swing (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x37 - Teleport To Entity (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| uuid| UUID| UUID|
 
#### 0x38 - Use Item On (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| blockHit| BlockHitResult| BlockHitResult|
| 1| 0| hand| InteractionHand| InteractionHand|
| 2| 0| sequence| int| int|
 
#### 0x39 - Use Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
| 1| 0| sequence| int| int|
 
