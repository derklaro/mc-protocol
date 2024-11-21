# 1.21.4 Pre-Release 1 (Snapshot)
| Series | Java Runtime | Java Version | Protocol Version | World Version | Resource Pack Version | Data Pack Version | Build Timestamp (UTC) |
| -------------| -------------| -------------| -------------| -------------| -------------| -------------| -------------|
| main| java-runtime-delta| 21| 1073742047| 4179| 46| 60| 20/11/2024 13:42:05|
## Handshake (Serverbound)
#### 0x00 - Client Intention (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| protocolVersion| int| int|
| 1| 0| hostName| String| String|
| 2| 1| port| int| int|
| 3| 0| intention| ClientIntent| ClientIntent|
 
## Status (Serverbound)
#### 0x00 - Status Request (C ➔ S)
Packet has no fields
 
#### 0x01 - Ping Request (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
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
| 0| 0| cooldownGroup| ResourceLocation| ResourceLocation|
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
 
#### 0x20 - Entity Position Sync (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| values| PositionMoveRotation| PositionMoveRotation|
| 2| 0| onGround| boolean| boolean|
 
#### 0x21 - Explode (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| center| Vec3| Vec3|
| 1| 0| playerKnockback| Optional| Optional&lt;Vec3&gt;|
| 2| 0| explosionParticle| ParticleOptions| ParticleOptions|
| 3| 0| explosionSound| Holder| Holder&lt;SoundEvent&gt;|
 
#### 0x22 - Forget Level Chunk (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| ChunkPos| ChunkPos|
 
#### 0x23 - Game Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| event| ClientboundGameEventPacket$Type| ClientboundGameEventPacket$Type|
| 1| 0| param| float| float|
 
#### 0x24 - Horse Screen Open (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| inventoryColumns| int| int|
| 2| 2| entityId| int| int|
 
#### 0x25 - Hurt Animation (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| yaw| float| float|
 
#### 0x26 - Initialize Border (S ➔ C)
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
 
#### 0x27 - Keep Alive (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x28 - Level Chunk With Light (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| chunkData| ClientboundLevelChunkPacketData| ClientboundLevelChunkPacketData|
| 3| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x29 - Level Event (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| type| int| int|
| 1| 0| pos| BlockPos| BlockPos|
| 2| 1| data| int| int|
| 3| 0| globalEvent| boolean| boolean|
 
#### 0x2A - Level Particles (S ➔ C)
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
| 9| 1| alwaysShow| boolean| boolean|
| 10| 0| particle| ParticleOptions| ParticleOptions|
 
#### 0x2B - Light Update (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x2C - Login (S ➔ C)
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
 
#### 0x2D - Map Item Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| mapId| MapId| MapId|
| 1| 0| scale| byte| byte|
| 2| 0| locked| boolean| boolean|
| 3| 0| decorations| Optional| Optional&lt;List&lt;MapDecoration&gt;&gt;|
| 4| 1| colorPatch| Optional| Optional&lt;MapItemSavedData$MapPatch&gt;|
 
#### 0x2E - Merchant Offers (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| offers| MerchantOffers| MerchantOffers|
| 2| 1| villagerLevel| int| int|
| 3| 2| villagerXp| int| int|
| 4| 0| showProgress| boolean| boolean|
| 5| 1| canRestock| boolean| boolean|
 
#### 0x2F - Pos (S ➔ C)
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
 
#### 0x30 - Pos Rot (S ➔ C)
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
 
#### 0x31 - Move Minecart (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| lerpSteps| List| List&lt;NewMinecartBehavior$MinecartStep&gt;|
 
#### 0x32 - Rot (S ➔ C)
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
 
#### 0x33 - Move Vehicle (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| position| Vec3| Vec3|
| 1| 0| yRot| float| float|
| 2| 1| xRot| float| float|
 
#### 0x34 - Open Book (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x35 - Open Screen (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| type| MenuType| MenuType&lt;?&gt;|
| 2| 0| title| Component| Component|
 
#### 0x36 - Open Sign Editor (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| isFrontText| boolean| boolean|
 
#### 0x37 - Ping (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x38 - Pong Response (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
#### 0x39 - Place Ghost Recipe (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipeDisplay| RecipeDisplay| RecipeDisplay|
 
#### 0x3A - Player Abilities (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| invulnerable| boolean| boolean|
| 1| 1| isFlying| boolean| boolean|
| 2| 2| canFly| boolean| boolean|
| 3| 3| instabuild| boolean| boolean|
| 4| 0| flyingSpeed| float| float|
| 5| 1| walkingSpeed| float| float|
 
#### 0x3B - Player Chat (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sender| UUID| UUID|
| 1| 0| index| int| int|
| 2| 0| signature| MessageSignature| MessageSignature|
| 3| 0| body| SignedMessageBody$Packed| SignedMessageBody$Packed|
| 4| 0| unsignedContent| Component| Component|
| 5| 0| filterMask| FilterMask| FilterMask|
| 6| 0| chatType| ChatType$Bound| ChatType$Bound|
 
#### 0x3C - Player Combat End (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| duration| int| int|
 
#### 0x3D - Player Combat Enter (S ➔ C)
Packet has no fields
 
#### 0x3E - Player Combat Kill (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| playerId| int| int|
| 1| 0| message| Component| Component|
 
#### 0x3F - Player Info Remove (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| profileIds| List| List&lt;UUID&gt;|
 
#### 0x40 - Player Info Update (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| actions| EnumSet| EnumSet&lt;ClientboundPlayerInfoUpdatePacket$Action&gt;|
| 1| 0| entries| List| List&lt;ClientboundPlayerInfoUpdatePacket$Entry&gt;|
 
#### 0x41 - Player Look At (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| entity| int| int|
| 4| 0| fromAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 5| 1| toAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 6| 0| atEntity| boolean| boolean|
 
#### 0x42 - Player Position (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| change| PositionMoveRotation| PositionMoveRotation|
| 2| 0| relatives| Set| Set&lt;Relative&gt;|
 
#### 0x43 - Player Rotation (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| yRot| float| float|
| 1| 1| xRot| float| float|
 
#### 0x44 - Recipe Book Add (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entries| List| List&lt;ClientboundRecipeBookAddPacket$Entry&gt;|
| 1| 0| replace| boolean| boolean|
 
#### 0x45 - Recipe Book Remove (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipes| List| List&lt;RecipeDisplayId&gt;|
 
#### 0x46 - Recipe Book Settings (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| bookSettings| RecipeBookSettings| RecipeBookSettings|
 
#### 0x47 - Remove Entities (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityIds| IntList| IntList|
 
#### 0x48 - Remove Mob Effect (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| Holder| Holder&lt;MobEffect&gt;|
 
#### 0x49 - Reset Score (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| owner| String| String|
| 1| 1| objectiveName| String| String|
 
#### 0x4A - Resource Pack Pop (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| Optional| Optional&lt;UUID&gt;|
 
#### 0x4B - Resource Pack Push (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| url| String| String|
| 2| 1| hash| String| String|
| 3| 0| required| boolean| boolean|
| 4| 0| prompt| Optional| Optional&lt;Component&gt;|
 
#### 0x4C - Respawn (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| commonPlayerSpawnInfo| CommonPlayerSpawnInfo| CommonPlayerSpawnInfo|
| 1| 0| dataToKeep| byte| byte|
 
#### 0x4D - Rotate Head (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| yHeadRot| byte| byte|
 
#### 0x4E - Section Blocks Update (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sectionPos| SectionPos| SectionPos|
| 1| 0| positions| short[]| short[]|
| 2| 0| states| BlockState[]| BlockState[]|
 
#### 0x4F - Select Advancements Tab (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x50 - Server Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| motd| Component| Component|
| 1| 0| iconBytes| Optional| Optional&lt;byte[]&gt;|
 
#### 0x51 - Set Action Bar Text (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x52 - Set Border Center (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| newCenterX| double| double|
| 1| 1| newCenterZ| double| double|
 
#### 0x53 - Set Border Lerp Size (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| oldSize| double| double|
| 1| 1| newSize| double| double|
| 2| 0| lerpTime| long| long|
 
#### 0x54 - Set Border Size (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| size| double| double|
 
#### 0x55 - Set Border Warning Delay (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningDelay| int| int|
 
#### 0x56 - Set Border Warning Distance (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningBlocks| int| int|
 
#### 0x57 - Set Camera (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| cameraId| int| int|
 
#### 0x58 - Set Chunk Cache Center (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
 
#### 0x59 - Set Chunk Cache Radius (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| radius| int| int|
 
#### 0x5A - Set Cursor Item (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| contents| ItemStack| ItemStack|
 
#### 0x5B - Set Default Spawn Position (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| angle| float| float|
 
#### 0x5C - Set Display Objective (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| DisplaySlot| DisplaySlot|
| 1| 0| objectiveName| String| String|
 
#### 0x5D - Set Entity Data (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| packedItems| List| List&lt;SynchedEntityData$DataValue&lt;?&gt;&gt;|
 
#### 0x5E - Set Entity Link (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sourceId| int| int|
| 1| 1| destId| int| int|
 
#### 0x5F - Set Entity Motion (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| xa| int| int|
| 2| 2| ya| int| int|
| 3| 3| za| int| int|
 
#### 0x60 - Set Equipment (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| slots| List| List&lt;Pair&lt;EquipmentSlot, ItemStack&gt;&gt;|
 
#### 0x61 - Set Experience (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| experienceProgress| float| float|
| 1| 0| totalExperience| int| int|
| 2| 1| experienceLevel| int| int|
 
#### 0x62 - Set Health (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| health| float| float|
| 1| 0| food| int| int|
| 2| 1| saturation| float| float|
 
#### 0x63 - Set Held Slot (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x64 - Set Objective (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| objectiveName| String| String|
| 1| 0| displayName| Component| Component|
| 2| 0| renderType| ObjectiveCriteria$RenderType| ObjectiveCriteria$RenderType|
| 3| 0| numberFormat| Optional| Optional&lt;NumberFormat&gt;|
| 4| 0| method| int| int|
 
#### 0x65 - Set Passengers (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| vehicle| int| int|
| 1| 0| passengers| int[]| int[]|
 
#### 0x66 - Set Player Inventory (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
| 1| 0| contents| ItemStack| ItemStack|
 
#### 0x67 - Set Player Team (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| method| int| int|
| 1| 0| name| String| String|
| 2| 0| players| Collection| Collection&lt;String&gt;|
| 3| 0| parameters| Optional| Optional&lt;ClientboundSetPlayerTeamPacket$Parameters&gt;|
 
#### 0x68 - Set Score (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| owner| String| String|
| 1| 1| objectiveName| String| String|
| 2| 0| score| int| int|
| 3| 0| display| Optional| Optional&lt;Component&gt;|
| 4| 1| numberFormat| Optional| Optional&lt;NumberFormat&gt;|
 
#### 0x69 - Set Simulation Distance (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| simulationDistance| int| int|
 
#### 0x6A - Set Subtitle Text (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x6B - Set Time (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| gameTime| long| long|
| 1| 1| dayTime| long| long|
| 2| 0| tickDayTime| boolean| boolean|
 
#### 0x6C - Set Title Text (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x6D - Set Titles Animation (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| fadeIn| int| int|
| 1| 1| stay| int| int|
| 2| 2| fadeOut| int| int|
 
#### 0x6E - Sound Entity (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sound| Holder| Holder&lt;SoundEvent&gt;|
| 1| 0| source| SoundSource| SoundSource|
| 2| 0| id| int| int|
| 3| 0| volume| float| float|
| 4| 1| pitch| float| float|
| 5| 0| seed| long| long|
 
#### 0x6F - Sound (S ➔ C)
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
 
#### 0x70 - Start Configuration (S ➔ C)
Packet has no fields
 
#### 0x71 - Stop Sound (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| ResourceLocation| ResourceLocation|
| 1| 0| source| SoundSource| SoundSource|
 
#### 0x72 - Store Cookie (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
| 1| 0| payload| byte[]| byte[]|
 
#### 0x73 - System Chat (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| content| Component| Component|
| 1| 0| overlay| boolean| boolean|
 
#### 0x74 - Tab List (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| header| Component| Component|
| 1| 1| footer| Component| Component|
 
#### 0x75 - Tag Query (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| tag| CompoundTag| CompoundTag|
 
#### 0x76 - Take Item Entity (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| itemId| int| int|
| 1| 1| playerId| int| int|
| 2| 2| amount| int| int|
 
#### 0x77 - Teleport Entity (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| change| PositionMoveRotation| PositionMoveRotation|
| 2| 0| relatives| Set| Set&lt;Relative&gt;|
| 3| 0| onGround| boolean| boolean|
 
#### 0x78 - Ticking State (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tickRate| float| float|
| 1| 0| isFrozen| boolean| boolean|
 
#### 0x79 - Ticking Step (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tickSteps| int| int|
 
#### 0x7A - Transfer (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| host| String| String|
| 1| 0| port| int| int|
 
#### 0x7B - Update Advancements (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reset| boolean| boolean|
| 1| 0| added| List| List&lt;AdvancementHolder&gt;|
| 2| 0| removed| Set| Set&lt;ResourceLocation&gt;|
| 3| 0| progress| Map| Map&lt;ResourceLocation, AdvancementProgress&gt;|
 
#### 0x7C - Update Attributes (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| attributes| List| List&lt;ClientboundUpdateAttributesPacket$AttributeSnapshot&gt;|
 
#### 0x7D - Update Mob Effect (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| Holder| Holder&lt;MobEffect&gt;|
| 2| 1| effectAmplifier| int| int|
| 3| 2| effectDurationTicks| int| int|
| 4| 0| flags| byte| byte|
 
#### 0x7E - Update Recipes (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| itemSets| Map| Map&lt;ResourceKey&lt;RecipePropertySet&gt;, RecipePropertySet&gt;|
| 1| 0| stonecutterRecipes| SelectableRecipe$SingleInputSet| SelectableRecipe$SingleInputSet&lt;StonecutterRecipe&gt;|
 
#### 0x7F - Update Tags (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tags| Map| Map&lt;ResourceKey&lt;? extends Registry&lt;?&gt;&gt;, TagNetworkSerialization$NetworkPayload&gt;|
 
#### 0x80 - Projectile Power (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| accelerationPower| double| double|
 
#### 0x81 - Custom Report Details (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| details| Map| Map&lt;String, String&gt;|
 
#### 0x82 - Server Links (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| links| List| List&lt;ServerLinks$UntrustedEntry&gt;|
 
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
 
#### 0x02 - Select Bundle Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotId| int| int|
| 1| 1| selectedItemIndex| int| int|
 
#### 0x03 - Change Difficulty (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| difficulty| Difficulty| Difficulty|
 
#### 0x04 - Chat Ack (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| offset| int| int|
 
#### 0x05 - Chat Command (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| command| String| String|
 
#### 0x06 - Chat Command Signed (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| command| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| argumentSignatures| ArgumentSignatures| ArgumentSignatures|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x07 - Chat (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| message| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| signature| MessageSignature| MessageSignature|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x08 - Chat Session Update (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| chatSession| RemoteChatSession$Data| RemoteChatSession$Data|
 
#### 0x09 - Chunk Batch Received (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| desiredChunksPerTick| float| float|
 
#### 0x0A - Client Command (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundClientCommandPacket$Action| ServerboundClientCommandPacket$Action|
 
#### 0x0B - Client Tick End (C ➔ S)
Packet has no fields
 
#### 0x0C - Client Information (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| information| ClientInformation| ClientInformation|
 
#### 0x0D - Command Suggestion (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| command| String| String|
 
#### 0x0E - Configuration Acknowledged (C ➔ S)
Packet has no fields
 
#### 0x0F - Container Button Click (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| buttonId| int| int|
 
#### 0x10 - Container Click (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 2| slotNum| int| int|
| 3| 3| buttonNum| int| int|
| 4| 0| clickType| ClickType| ClickType|
| 5| 0| carriedItem| ItemStack| ItemStack|
| 6| 0| changedSlots| Int2ObjectMap| Int2ObjectMap&lt;ItemStack&gt;|
 
#### 0x11 - Container Close (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
 
#### 0x12 - Container Slot State Changed (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotId| int| int|
| 1| 1| containerId| int| int|
| 2| 0| newState| boolean| boolean|
 
#### 0x13 - Cookie Response (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| key| ResourceLocation| ResourceLocation|
| 1| 0| payload| byte[]| byte[]|
 
#### 0x14 - Custom Payload (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x15 - Debug Sample Subscription (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sampleType| RemoteDebugSampleType| RemoteDebugSampleType|
 
#### 0x16 - Edit Book (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
| 1| 0| pages| List| List&lt;String&gt;|
| 2| 0| title| Optional| Optional&lt;String&gt;|
 
#### 0x17 - Entity Tag Query (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 1| entityId| int| int|
 
#### 0x18 - Interact (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| action| ServerboundInteractPacket$Action| ServerboundInteractPacket$Action|
| 2| 0| usingSecondaryAction| boolean| boolean|
 
#### 0x19 - Jigsaw Generate (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| levels| int| int|
| 2| 0| keepJigsaws| boolean| boolean|
 
#### 0x1A - Keep Alive (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x1B - Lock Difficulty (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| locked| boolean| boolean|
 
#### 0x1C - Pos (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| horizontalCollision| boolean| boolean|
| 7| 2| hasPos| boolean| boolean|
| 8| 3| hasRot| boolean| boolean|
 
#### 0x1D - Pos Rot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| horizontalCollision| boolean| boolean|
| 7| 2| hasPos| boolean| boolean|
| 8| 3| hasRot| boolean| boolean|
 
#### 0x1E - Rot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| horizontalCollision| boolean| boolean|
| 7| 2| hasPos| boolean| boolean|
| 8| 3| hasRot| boolean| boolean|
 
#### 0x1F - Status Only (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| horizontalCollision| boolean| boolean|
| 7| 2| hasPos| boolean| boolean|
| 8| 3| hasRot| boolean| boolean|
 
#### 0x20 - Move Vehicle (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| position| Vec3| Vec3|
| 1| 0| yRot| float| float|
| 2| 1| xRot| float| float|
| 3| 0| onGround| boolean| boolean|
 
#### 0x21 - Paddle Boat (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| left| boolean| boolean|
| 1| 1| right| boolean| boolean|
 
#### 0x22 - Pick Item From Block (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| includeData| boolean| boolean|
 
#### 0x23 - Pick Item From Entity (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| includeData| boolean| boolean|
 
#### 0x24 - Ping Request (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
#### 0x25 - Place Recipe (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipe| RecipeDisplayId| RecipeDisplayId|
| 2| 0| useMaxItems| boolean| boolean|
 
#### 0x26 - Player Abilities (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| isFlying| boolean| boolean|
 
#### 0x27 - Player Action (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| direction| Direction| Direction|
| 2| 0| action| ServerboundPlayerActionPacket$Action| ServerboundPlayerActionPacket$Action|
| 3| 0| sequence| int| int|
 
#### 0x28 - Player Command (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| action| ServerboundPlayerCommandPacket$Action| ServerboundPlayerCommandPacket$Action|
| 2| 1| data| int| int|
 
#### 0x29 - Player Input (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| input| Input| Input|
 
#### 0x2A - Player Loaded (C ➔ S)
Packet has no fields
 
#### 0x2B - Pong (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x2C - Recipe Book Change Settings (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| bookType| RecipeBookType| RecipeBookType|
| 1| 0| isOpen| boolean| boolean|
| 2| 1| isFiltering| boolean| boolean|
 
#### 0x2D - Recipe Book Seen Recipe (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipe| RecipeDisplayId| RecipeDisplayId|
 
#### 0x2E - Rename Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| String| String|
 
#### 0x2F - Resource Pack (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| action| ServerboundResourcePackPacket$Action| ServerboundResourcePackPacket$Action|
 
#### 0x30 - Seen Advancements (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundSeenAdvancementsPacket$Action| ServerboundSeenAdvancementsPacket$Action|
| 1| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x31 - Select Trade (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| item| int| int|
 
#### 0x32 - Set Beacon (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| primary| Optional| Optional&lt;Holder&lt;MobEffect&gt;&gt;|
| 1| 1| secondary| Optional| Optional&lt;Holder&lt;MobEffect&gt;&gt;|
 
#### 0x33 - Set Carried Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x34 - Set Command Block (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
| 3| 1| conditional| boolean| boolean|
| 4| 2| automatic| boolean| boolean|
| 5| 0| mode| CommandBlockEntity$Mode| CommandBlockEntity$Mode|
 
#### 0x35 - Set Command Minecart (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
 
#### 0x36 - Set Creative Mode Slot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotNum| short| short|
| 1| 0| itemStack| ItemStack| ItemStack|
 
#### 0x37 - Set Jigsaw Block (C ➔ S)
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
 
#### 0x38 - Set Structure Block (C ➔ S)
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
 
#### 0x39 - Sign Update (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| lines| String[]| String[]|
| 2| 0| isFrontText| boolean| boolean|
 
#### 0x3A - Swing (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x3B - Teleport To Entity (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| uuid| UUID| UUID|
 
#### 0x3C - Use Item On (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| blockHit| BlockHitResult| BlockHitResult|
| 1| 0| hand| InteractionHand| InteractionHand|
| 2| 0| sequence| int| int|
 
#### 0x3D - Use Item (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
| 1| 0| sequence| int| int|
| 2| 0| yRot| float| float|
| 3| 1| xRot| float| float|
 
