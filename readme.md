# 23w46a (Snapshot)
| Series | Java Runtime | Java Version | Protocol Version | World Version | Pack Resource Version | Pack Data Version | Built at (UTC) |
| -------------| -------------| -------------| -------------| -------------| -------------| -------------| -------------|
| main| java-runtime-gamma| 17| 1073741987| 3691| 21| 25| 16/11/2023 14:05:25|
## Handshaking (Serverbound)
#### 0x00 - Client Intention Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| protocolVersion| int| int|
| 1| 0| hostName| String| String|
| 2| 1| port| int| int|
| 3| 0| intention| ClientIntent| ClientIntent|
 
## Handshaking (Clientbound)
This packet flow has no registered packets
## Play (Serverbound)
#### 0x00 - Accept Teleportation Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x01 - Block Entity Tag Query (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| pos| BlockPos| BlockPos|
 
#### 0x02 - Change Difficulty Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| difficulty| Difficulty| Difficulty|
 
#### 0x03 - Chat Ack Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| offset| int| int|
 
#### 0x04 - Chat Command Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| command| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| argumentSignatures| ArgumentSignatures| ArgumentSignatures|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x05 - Chat Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| message| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| signature| MessageSignature| MessageSignature|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x06 - Chat Session Update Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| chatSession| RemoteChatSession$Data| RemoteChatSession$Data|
 
#### 0x07 - Chunk Batch Received Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| desiredChunksPerTick| float| float|
 
#### 0x08 - Client Command Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundClientCommandPacket$Action| ServerboundClientCommandPacket$Action|
 
#### 0x09 - Client Information Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| information| ClientInformation| ClientInformation|
 
#### 0x0A - Command Suggestion Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| command| String| String|
 
#### 0x0B - Configuration Acknowledged Packet (C ➔ S)
Packet has no fields
 
#### 0x0C - Container Button Click Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| buttonId| int| int|
 
#### 0x0D - Container Click Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 2| slotNum| int| int|
| 3| 3| buttonNum| int| int|
| 4| 0| clickType| ClickType| ClickType|
| 5| 0| carriedItem| ItemStack| ItemStack|
| 6| 0| changedSlots| Int2ObjectMap| Int2ObjectMap&lt;ItemStack&gt;|
 
#### 0x0E - Container Close Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
 
#### 0x0F - Container Slot State Changed Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotId| int| int|
| 1| 1| containerId| int| int|
| 2| 0| newState| boolean| boolean|
 
#### 0x10 - Custom Payload Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x11 - Edit Book Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
| 1| 0| pages| List| List&lt;String&gt;|
| 2| 0| title| Optional| Optional&lt;String&gt;|
 
#### 0x12 - Entity Tag Query (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 1| entityId| int| int|
 
#### 0x13 - Interact Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| action| ServerboundInteractPacket$Action| ServerboundInteractPacket$Action|
| 2| 0| usingSecondaryAction| boolean| boolean|
 
#### 0x14 - Jigsaw Generate Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| levels| int| int|
| 2| 0| keepJigsaws| boolean| boolean|
 
#### 0x15 - Keep Alive Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x16 - Lock Difficulty Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| locked| boolean| boolean|
 
#### 0x17 - Pos (C ➔ S)
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
 
#### 0x18 - Pos Rot (C ➔ S)
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
 
#### 0x19 - Rot (C ➔ S)
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
 
#### 0x1A - Status Only (C ➔ S)
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
 
#### 0x1B - Move Vehicle Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
 
#### 0x1C - Paddle Boat Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| left| boolean| boolean|
| 1| 1| right| boolean| boolean|
 
#### 0x1D - Pick Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x1E - Ping Request Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
#### 0x1F - Place Recipe Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipe| ResourceLocation| ResourceLocation|
| 2| 0| shiftDown| boolean| boolean|
 
#### 0x20 - Player Abilities Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| isFlying| boolean| boolean|
 
#### 0x21 - Player Action Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| direction| Direction| Direction|
| 2| 0| action| ServerboundPlayerActionPacket$Action| ServerboundPlayerActionPacket$Action|
| 3| 0| sequence| int| int|
 
#### 0x22 - Player Command Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| action| ServerboundPlayerCommandPacket$Action| ServerboundPlayerCommandPacket$Action|
| 2| 1| data| int| int|
 
#### 0x23 - Player Input Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| xxa| float| float|
| 1| 1| zza| float| float|
| 2| 0| isJumping| boolean| boolean|
| 3| 1| isShiftKeyDown| boolean| boolean|
 
#### 0x24 - Pong Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x25 - Recipe Book Change Settings Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| bookType| RecipeBookType| RecipeBookType|
| 1| 0| isOpen| boolean| boolean|
| 2| 1| isFiltering| boolean| boolean|
 
#### 0x26 - Recipe Book Seen Recipe Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipe| ResourceLocation| ResourceLocation|
 
#### 0x27 - Rename Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| String| String|
 
#### 0x28 - Resource Pack Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundResourcePackPacket$Action| ServerboundResourcePackPacket$Action|
 
#### 0x29 - Seen Advancements Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundSeenAdvancementsPacket$Action| ServerboundSeenAdvancementsPacket$Action|
| 1| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x2A - Select Trade Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| item| int| int|
 
#### 0x2B - Set Beacon Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| primary| Optional| Optional&lt;MobEffect&gt;|
| 1| 1| secondary| Optional| Optional&lt;MobEffect&gt;|
 
#### 0x2C - Set Carried Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x2D - Set Command Block Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
| 3| 1| conditional| boolean| boolean|
| 4| 2| automatic| boolean| boolean|
| 5| 0| mode| CommandBlockEntity$Mode| CommandBlockEntity$Mode|
 
#### 0x2E - Set Command Minecart Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
 
#### 0x2F - Set Creative Mode Slot Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotNum| int| int|
| 1| 0| itemStack| ItemStack| ItemStack|
 
#### 0x30 - Set Jigsaw Block Packet (C ➔ S)
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
 
#### 0x31 - Set Structure Block Packet (C ➔ S)
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
 
#### 0x32 - Sign Update Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| lines| String[]| String[]|
| 2| 0| isFrontText| boolean| boolean|
 
#### 0x33 - Swing Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x34 - Teleport To Entity Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| uuid| UUID| UUID|
 
#### 0x35 - Use Item On Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| blockHit| BlockHitResult| BlockHitResult|
| 1| 0| hand| InteractionHand| InteractionHand|
| 2| 0| sequence| int| int|
 
#### 0x36 - Use Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
| 1| 0| sequence| int| int|
 
## Play (Clientbound)
#### 0x00 - Bundle Delimiter Packet (S ➔ C)
Packet has no fields
 
#### 0x01 - Add Entity Packet (S ➔ C)
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
 
#### 0x02 - Add Experience Orb Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| x| double| double|
| 2| 1| y| double| double|
| 3| 2| z| double| double|
| 4| 1| value| int| int|
 
#### 0x03 - Animate Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| action| int| int|
 
#### 0x04 - Award Stats Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| stats| Object2IntMap| Object2IntMap&lt;Stat&lt;?&gt;&gt;|
 
#### 0x05 - Block Changed Ack Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sequence| int| int|
 
#### 0x06 - Block Destruction Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| pos| BlockPos| BlockPos|
| 2| 1| progress| int| int|
 
#### 0x07 - Block Entity Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| type| BlockEntityType| BlockEntityType&lt;?&gt;|
| 2| 0| tag| CompoundTag| CompoundTag|
 
#### 0x08 - Block Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| b0| int| int|
| 2| 1| b1| int| int|
| 3| 0| block| Block| Block|
 
#### 0x09 - Block Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| blockState| BlockState| BlockState|
 
#### 0x0A - Boss Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| operation| ClientboundBossEventPacket$Operation| ClientboundBossEventPacket$Operation|
 
#### 0x0B - Change Difficulty Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| difficulty| Difficulty| Difficulty|
| 1| 0| locked| boolean| boolean|
 
#### 0x0C - Chunk Batch Finished Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| batchSize| int| int|
 
#### 0x0D - Chunk Batch Start Packet (S ➔ C)
Packet has no fields
 
#### 0x0E - Chunks Biomes Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| chunkBiomeData| List| List&lt;ClientboundChunksBiomesPacket$ChunkBiomeData&gt;|
 
#### 0x0F - Clear Titles Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| resetTimes| boolean| boolean|
 
#### 0x10 - Command Suggestions Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| suggestions| Suggestions| Suggestions|
 
#### 0x11 - Commands Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| rootIndex| int| int|
| 1| 0| entries| List| List&lt;ClientboundCommandsPacket$Entry&gt;|
 
#### 0x12 - Container Close Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
 
#### 0x13 - Container Set Content Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 0| items| List| List&lt;ItemStack&gt;|
| 3| 0| carriedItem| ItemStack| ItemStack|
 
#### 0x14 - Container Set Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| id| int| int|
| 2| 2| value| int| int|
 
#### 0x15 - Container Set Slot Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 2| slot| int| int|
| 3| 0| itemStack| ItemStack| ItemStack|
 
#### 0x16 - Cooldown Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| item| Item| Item|
| 1| 0| duration| int| int|
 
#### 0x17 - Custom Chat Completions Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ClientboundCustomChatCompletionsPacket$Action| ClientboundCustomChatCompletionsPacket$Action|
| 1| 0| entries| List| List&lt;String&gt;|
 
#### 0x18 - Custom Payload Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x19 - Damage Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 1| sourceTypeId| int| int|
| 2| 2| sourceCauseId| int| int|
| 3| 3| sourceDirectId| int| int|
| 4| 0| sourcePosition| Optional| Optional&lt;Vec3&gt;|
 
#### 0x1A - Delete Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| messageSignature| MessageSignature$Packed| MessageSignature$Packed|
 
#### 0x1B - Disconnect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x1C - Disguised Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| message| Component| Component|
| 1| 0| chatType| ChatType$BoundNetwork| ChatType$BoundNetwork|
 
#### 0x1D - Entity Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| eventId| byte| byte|
 
#### 0x1E - Explode Packet (S ➔ C)
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
| 11| 0| explosionSound| SoundEvent| SoundEvent|
 
#### 0x1F - Forget Level Chunk Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| ChunkPos| ChunkPos|
 
#### 0x20 - Game Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| event| ClientboundGameEventPacket$Type| ClientboundGameEventPacket$Type|
| 1| 0| param| float| float|
 
#### 0x21 - Horse Screen Open Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| size| int| int|
| 2| 2| entityId| int| int|
 
#### 0x22 - Hurt Animation Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| yaw| float| float|
 
#### 0x23 - Initialize Border Packet (S ➔ C)
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
 
#### 0x24 - Keep Alive Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x25 - Level Chunk With Light Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| chunkData| ClientboundLevelChunkPacketData| ClientboundLevelChunkPacketData|
| 3| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x26 - Level Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| type| int| int|
| 1| 0| pos| BlockPos| BlockPos|
| 2| 1| data| int| int|
| 3| 0| globalEvent| boolean| boolean|
 
#### 0x27 - Level Particles Packet (S ➔ C)
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
 
#### 0x28 - Light Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x29 - Login Packet (S ➔ C)
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
 
#### 0x2A - Map Item Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| mapId| int| int|
| 1| 0| scale| byte| byte|
| 2| 0| locked| boolean| boolean|
| 3| 0| decorations| List| List&lt;MapDecoration&gt;|
| 4| 0| colorPatch| MapItemSavedData$MapPatch| MapItemSavedData$MapPatch|
 
#### 0x2B - Merchant Offers Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| offers| MerchantOffers| MerchantOffers|
| 2| 1| villagerLevel| int| int|
| 3| 2| villagerXp| int| int|
| 4| 0| showProgress| boolean| boolean|
| 5| 1| canRestock| boolean| boolean|
 
#### 0x2C - Pos (S ➔ C)
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
 
#### 0x2D - Pos Rot (S ➔ C)
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
 
#### 0x2E - Rot (S ➔ C)
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
 
#### 0x2F - Move Vehicle Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
 
#### 0x30 - Open Book Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x31 - Open Screen Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| type| MenuType| MenuType&lt;?&gt;|
| 2| 0| title| Component| Component|
 
#### 0x32 - Open Sign Editor Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| isFrontText| boolean| boolean|
 
#### 0x33 - Ping Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x34 - Pong Response Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
#### 0x35 - Place Ghost Recipe Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipe| ResourceLocation| ResourceLocation|
 
#### 0x36 - Player Abilities Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| invulnerable| boolean| boolean|
| 1| 1| isFlying| boolean| boolean|
| 2| 2| canFly| boolean| boolean|
| 3| 3| instabuild| boolean| boolean|
| 4| 0| flyingSpeed| float| float|
| 5| 1| walkingSpeed| float| float|
 
#### 0x37 - Player Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sender| UUID| UUID|
| 1| 0| index| int| int|
| 2| 0| signature| MessageSignature| MessageSignature|
| 3| 0| body| SignedMessageBody$Packed| SignedMessageBody$Packed|
| 4| 0| unsignedContent| Component| Component|
| 5| 0| filterMask| FilterMask| FilterMask|
| 6| 0| chatType| ChatType$BoundNetwork| ChatType$BoundNetwork|
 
#### 0x38 - Player Combat End Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| duration| int| int|
 
#### 0x39 - Player Combat Enter Packet (S ➔ C)
Packet has no fields
 
#### 0x3A - Player Combat Kill Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| playerId| int| int|
| 1| 0| message| Component| Component|
 
#### 0x3B - Player Info Remove Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| profileIds| List| List&lt;UUID&gt;|
 
#### 0x3C - Player Info Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| actions| EnumSet| EnumSet&lt;ClientboundPlayerInfoUpdatePacket$Action&gt;|
| 1| 0| entries| List| List&lt;ClientboundPlayerInfoUpdatePacket$Entry&gt;|
 
#### 0x3D - Player Look At Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| entity| int| int|
| 4| 0| fromAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 5| 1| toAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 6| 0| atEntity| boolean| boolean|
 
#### 0x3E - Player Position Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| relativeArguments| Set| Set&lt;RelativeMovement&gt;|
| 6| 0| id| int| int|
 
#### 0x3F - Recipe Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| state| ClientboundRecipePacket$State| ClientboundRecipePacket$State|
| 1| 0| recipes| List| List&lt;ResourceLocation&gt;|
| 2| 1| toHighlight| List| List&lt;ResourceLocation&gt;|
| 3| 0| bookSettings| RecipeBookSettings| RecipeBookSettings|
 
#### 0x40 - Remove Entities Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityIds| IntList| IntList|
 
#### 0x41 - Remove Mob Effect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| MobEffect| MobEffect|
 
#### 0x42 - Reset Score Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| owner| String| String|
| 1| 1| objectiveName| String| String|
 
#### 0x43 - Resource Pack Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| url| String| String|
| 1| 1| hash| String| String|
| 2| 0| required| boolean| boolean|
| 3| 0| prompt| Component| Component|
 
#### 0x44 - Respawn Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| commonPlayerSpawnInfo| CommonPlayerSpawnInfo| CommonPlayerSpawnInfo|
| 1| 0| dataToKeep| byte| byte|
 
#### 0x45 - Rotate Head Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| yHeadRot| byte| byte|
 
#### 0x46 - Section Blocks Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sectionPos| SectionPos| SectionPos|
| 1| 0| positions| short[]| short[]|
| 2| 0| states| BlockState[]| BlockState[]|
 
#### 0x47 - Select Advancements Tab Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x48 - Server Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| motd| Component| Component|
| 1| 0| iconBytes| Optional| Optional&lt;byte[]&gt;|
| 2| 0| enforcesSecureChat| boolean| boolean|
 
#### 0x49 - Set Action Bar Text Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x4A - Set Border Center Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| newCenterX| double| double|
| 1| 1| newCenterZ| double| double|
 
#### 0x4B - Set Border Lerp Size Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| oldSize| double| double|
| 1| 1| newSize| double| double|
| 2| 0| lerpTime| long| long|
 
#### 0x4C - Set Border Size Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| size| double| double|
 
#### 0x4D - Set Border Warning Delay Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningDelay| int| int|
 
#### 0x4E - Set Border Warning Distance Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningBlocks| int| int|
 
#### 0x4F - Set Camera Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| cameraId| int| int|
 
#### 0x50 - Set Carried Item Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x51 - Set Chunk Cache Center Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
 
#### 0x52 - Set Chunk Cache Radius Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| radius| int| int|
 
#### 0x53 - Set Default Spawn Position Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| angle| float| float|
 
#### 0x54 - Set Display Objective Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| DisplaySlot| DisplaySlot|
| 1| 0| objectiveName| String| String|
 
#### 0x55 - Set Entity Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| packedItems| List| List&lt;SynchedEntityData$DataValue&lt;?&gt;&gt;|
 
#### 0x56 - Set Entity Link Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sourceId| int| int|
| 1| 1| destId| int| int|
 
#### 0x57 - Set Entity Motion Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| xa| int| int|
| 2| 2| ya| int| int|
| 3| 3| za| int| int|
 
#### 0x58 - Set Equipment Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| slots| List| List&lt;Pair&lt;EquipmentSlot, ItemStack&gt;&gt;|
 
#### 0x59 - Set Experience Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| experienceProgress| float| float|
| 1| 0| totalExperience| int| int|
| 2| 1| experienceLevel| int| int|
 
#### 0x5A - Set Health Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| health| float| float|
| 1| 0| food| int| int|
| 2| 1| saturation| float| float|
 
#### 0x5B - Set Objective Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| objectiveName| String| String|
| 1| 0| displayName| Component| Component|
| 2| 0| renderType| ObjectiveCriteria$RenderType| ObjectiveCriteria$RenderType|
| 3| 0| numberFormat| NumberFormat| NumberFormat|
| 4| 0| method| int| int|
 
#### 0x5C - Set Passengers Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| vehicle| int| int|
| 1| 0| passengers| int[]| int[]|
 
#### 0x5D - Set Player Team Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| method| int| int|
| 1| 0| name| String| String|
| 2| 0| players| Collection| Collection&lt;String&gt;|
| 3| 0| parameters| Optional| Optional&lt;ClientboundSetPlayerTeamPacket$Parameters&gt;|
 
#### 0x5E - Set Score Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| owner| String| String|
| 1| 1| objectiveName| String| String|
| 2| 0| score| int| int|
| 3| 0| display| Component| Component|
| 4| 0| numberFormat| NumberFormat| NumberFormat|
 
#### 0x5F - Set Simulation Distance Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| simulationDistance| int| int|
 
#### 0x60 - Set Subtitle Text Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x61 - Set Time Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| gameTime| long| long|
| 1| 1| dayTime| long| long|
 
#### 0x62 - Set Title Text Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x63 - Set Titles Animation Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| fadeIn| int| int|
| 1| 1| stay| int| int|
| 2| 2| fadeOut| int| int|
 
#### 0x64 - Sound Entity Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sound| Holder| Holder&lt;SoundEvent&gt;|
| 1| 0| source| SoundSource| SoundSource|
| 2| 0| id| int| int|
| 3| 0| volume| float| float|
| 4| 1| pitch| float| float|
| 5| 0| seed| long| long|
 
#### 0x65 - Sound Packet (S ➔ C)
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
 
#### 0x66 - Start Configuration Packet (S ➔ C)
Packet has no fields
 
#### 0x67 - Stop Sound Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| ResourceLocation| ResourceLocation|
| 1| 0| source| SoundSource| SoundSource|
 
#### 0x68 - System Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| content| Component| Component|
| 1| 0| overlay| boolean| boolean|
 
#### 0x69 - Tab List Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| header| Component| Component|
| 1| 1| footer| Component| Component|
 
#### 0x6A - Tag Query Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| tag| CompoundTag| CompoundTag|
 
#### 0x6B - Take Item Entity Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| itemId| int| int|
| 1| 1| playerId| int| int|
| 2| 2| amount| int| int|
 
#### 0x6C - Teleport Entity Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| x| double| double|
| 2| 1| y| double| double|
| 3| 2| z| double| double|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
 
#### 0x6D - Ticking State Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tickRate| float| float|
| 1| 0| isFrozen| boolean| boolean|
 
#### 0x6E - Ticking Step Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tickSteps| int| int|
 
#### 0x6F - Update Advancements Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reset| boolean| boolean|
| 1| 0| added| List| List&lt;AdvancementHolder&gt;|
| 2| 0| removed| Set| Set&lt;ResourceLocation&gt;|
| 3| 0| progress| Map| Map&lt;ResourceLocation, AdvancementProgress&gt;|
 
#### 0x70 - Update Attributes Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| attributes| List| List&lt;ClientboundUpdateAttributesPacket$AttributeSnapshot&gt;|
 
#### 0x71 - Update Mob Effect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| MobEffect| MobEffect|
| 2| 0| effectAmplifier| byte| byte|
| 3| 1| effectDurationTicks| int| int|
| 4| 1| flags| byte| byte|
| 5| 0| factorData| MobEffectInstance$FactorData| MobEffectInstance$FactorData|
 
#### 0x72 - Update Recipes Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipes| List| List&lt;RecipeHolder&lt;?&gt;&gt;|
 
#### 0x73 - Update Tags Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tags| Map| Map&lt;ResourceKey&lt;? extends Registry&lt;?&gt;&gt;, TagNetworkSerialization$NetworkPayload&gt;|
 
## Status (Serverbound)
#### 0x00 - Status Request Packet (C ➔ S)
Packet has no fields
 
#### 0x01 - Ping Request Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
## Status (Clientbound)
#### 0x00 - Status Response Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| status| ServerStatus| ServerStatus|
 
#### 0x01 - Pong Response Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
## Login (Serverbound)
#### 0x00 - Hello Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| String| String|
| 1| 0| profileId| UUID| UUID|
 
#### 0x01 - Key Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| keybytes| byte[]| byte[]|
| 1| 1| encryptedChallenge| byte[]| byte[]|
 
#### 0x02 - Custom Query Answer Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| payload| CustomQueryAnswerPayload| CustomQueryAnswerPayload|
 
#### 0x03 - Login Acknowledged Packet (C ➔ S)
Packet has no fields
 
## Login (Clientbound)
#### 0x00 - Login Disconnect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x01 - Hello Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| serverId| String| String|
| 1| 0| publicKey| byte[]| byte[]|
| 2| 1| challenge| byte[]| byte[]|
 
#### 0x02 - Game Profile Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| gameProfile| GameProfile| GameProfile|
 
#### 0x03 - Login Compression Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| compressionThreshold| int| int|
 
#### 0x04 - Custom Query Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| payload| CustomQueryPayload| CustomQueryPayload|
 
## Configuration (Serverbound)
#### 0x00 - Client Information Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| information| ClientInformation| ClientInformation|
 
#### 0x01 - Custom Payload Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x02 - Finish Configuration Packet (C ➔ S)
Packet has no fields
 
#### 0x03 - Keep Alive Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x04 - Pong Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x05 - Resource Pack Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundResourcePackPacket$Action| ServerboundResourcePackPacket$Action|
 
## Configuration (Clientbound)
#### 0x00 - Custom Payload Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| payload| CustomPacketPayload| CustomPacketPayload|
 
#### 0x01 - Disconnect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x02 - Finish Configuration Packet (S ➔ C)
Packet has no fields
 
#### 0x03 - Keep Alive Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x04 - Ping Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x05 - Registry Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| registryHolder| RegistryAccess$Frozen| RegistryAccess$Frozen|
 
#### 0x06 - Resource Pack Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| url| String| String|
| 1| 1| hash| String| String|
| 2| 0| required| boolean| boolean|
| 3| 0| prompt| Component| Component|
 
#### 0x07 - Update Enabled Features Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| features| Set| Set&lt;ResourceLocation&gt;|
 
#### 0x08 - Update Tags Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tags| Map| Map&lt;ResourceKey&lt;? extends Registry&lt;?&gt;&gt;, TagNetworkSerialization$NetworkPayload&gt;|
 
